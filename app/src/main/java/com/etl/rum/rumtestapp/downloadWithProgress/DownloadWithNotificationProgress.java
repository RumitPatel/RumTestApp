package com.etl.rum.rumtestapp.downloadWithProgress;

import android.app.DownloadManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.etl.rum.rumtestapp.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadWithNotificationProgress extends AppCompatActivity {
    //    String url = "https://cdn.pixabay.com/photo/2017/02/06/12/34/reptile-2042906_1280.jpg";
    String url = "http://nourishwel.in//admin_anytimehealthcare//data//healthrecord//passbookstmt1.pdf";
    private long downloadID;
    //    String url = "http://www.odishaonlinemedicinestore.com/new/tfc%20ep4%2048.mkv";
    private Context mContext;

    // Download content START
    private final int maxProgress = 100;
    private float contentLength = 0;
    private float downloaded = 0;
    private final int DOWNLOAD_NOTIFICATION_ID = 1001;
    private NotificationCompat.Builder notificationBuilder;
    private NotificationManagerCompat notificationManagerCompat;
    // Download content END
    private final BroadcastReceiver onDownloadComplete = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //Fetching the download id received with the broadcast
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            //Checking if the received broadcast is for our enqueued download by matching download id
            if (downloadID == id) {
                Toast.makeText(mContext, "Download Completed", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_with_progress);

        mContext = this;
        registerReceiver(onDownloadComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDownLoadWithThread();
            }
        });
    }

    private void startDownLoadWithThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    downLoadFileFromWeb();
                    beginDownload();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void prepareNotificationBuilder() {

        notificationManagerCompat = NotificationManagerCompat.from(DownloadWithNotificationProgress.this);

        Intent notifyIntent = new Intent();
        PendingIntent notifyPendingIntent = PendingIntent.getActivity(DownloadWithNotificationProgress.this, DOWNLOAD_NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        notificationBuilder = NotificationUtils.createNotificationBuilder(mContext, "downloader_channel");
        notificationBuilder.setContentIntent(notifyPendingIntent);
        notificationBuilder.setTicker("Start downloading from the server");
        notificationBuilder.setOngoing(true);
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setSmallIcon(android.R.drawable.stat_sys_download);
        notificationBuilder.setContentTitle("Start downloading");
        notificationBuilder.setContentText("0%");
        notificationBuilder.setProgress(maxProgress, 0, false);
        notificationManagerCompat.notify(DOWNLOAD_NOTIFICATION_ID, notificationBuilder.build());
    }

    private void updateNotificationProgress() {
        System.out.println(" " + downloaded + "/" + contentLength + " = " + ((downloaded / contentLength) * maxProgress));
        float progressPercentage = ((downloaded / contentLength) * maxProgress);

        notificationBuilder.setContentText(" " + downloaded + "/" + contentLength + " = " + progressPercentage);
        notificationBuilder.setProgress(maxProgress, (int) progressPercentage, false);
        notificationManagerCompat.notify(DOWNLOAD_NOTIFICATION_ID, notificationBuilder.build());
    }

    private void completeNotificationProgress(boolean success) {
        updatePendingInetntForNotification(); // optional

        String statusText = success ? "Download Done" : "Download Fail";
        int resId = success ? android.R.drawable.stat_sys_download_done : android.R.drawable.stat_notify_error;
        notificationBuilder.setContentTitle("Downloaded");
        notificationBuilder.setSmallIcon(resId);
        notificationBuilder.setOngoing(false);
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setContentText(statusText);
        notificationBuilder.setProgress(0, 0, false);
        notificationManagerCompat.notify(DOWNLOAD_NOTIFICATION_ID, notificationBuilder.build());
    }

    private void downLoadFileFromWeb() {

        prepareNotificationBuilder();

        boolean success;
        try {
            OkHttpClient client = new OkHttpClient();
            Call call = client.newCall(new Request.Builder().url(url).get().build());
            Response response = call.execute();

            System.out.println("" + response.headers().toString());
            assert response.body() != null;
            System.out.println("total Byts: " + response.body().contentLength());
            InputStream inputStream = response.body().byteStream();

            String fileStoragePath = Environment.getExternalStorageDirectory().toString() + "/" + getString(R.string.app_name);
            File myDir = new File(fileStoragePath);
            if (!myDir.exists()) {
                if (!myDir.mkdirs()) {
                    return;
                }
            }

            String strFileNameWithExtention = new File(url).getName(); // get name from url
            File outputFile = new File(myDir, strFileNameWithExtention);
            OutputStream fileOutputStream = new FileOutputStream(outputFile);

            System.out.println("writing file " + contentLength);

            contentLength = (float) response.body().contentLength();
            downloaded = 0;

            /*
             * IF BUFFER_SIZE IS 1 file is downloaded properly
             * if BUFFER_SIZE is 1024 file is corrupted
             * open the downloaded image to test
             */
            //byte[] BUFFER_SIZE = new byte[1]; //Proper Download
            byte[] BUFFER_SIZE = new byte[1024]; //File Corrupt

            while (true) {
                int byteRead = inputStream.read(BUFFER_SIZE);
                if (byteRead == -1) {
                    break;
                }
                downloaded += byteRead;
                fileOutputStream.write(BUFFER_SIZE, 0, byteRead);
                updateNotificationProgress();
            }

            // flushing output
            fileOutputStream.flush();

            // closing streams
            fileOutputStream.flush();
            fileOutputStream.close();

            success = true;

        } catch (IOException e) {
            Log.e("m_tag", "[Download Error]: " + e.getMessage());
            success = false;
        }

        completeNotificationProgress(success);
        System.out.println("file closed");
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void updatePendingInetntForNotification() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//        Uri uri = Uri.parse(fileStoragePath);
//        intent.setDataAndType(uri, "*/*");
        intent.setType("*/*");
        PendingIntent notifyPendingIntent = PendingIntent.getActivity(
                mContext,
                DOWNLOAD_NOTIFICATION_ID,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        notificationBuilder.setContentIntent(notifyPendingIntent);
    }

    private void beginDownload() {
        File file = new File(getExternalFilesDir(null), "Dummy");
           /*
           Create a DownloadManager.Request with all the information necessary to start the download
            */
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse("http://nourishwel.in//admin_anytimehealthcare//data//healthrecord//passbookstmt1.pdf"))
                .setTitle("Dummy File")// Title of the Download Notification
                .setDescription("Downloading")// Description of the Download Notification
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)// Visibility of the download Notification
                .setDestinationUri(Uri.fromFile(file))// Uri of the destination file
//                .setRequiresCharging(false)// Set if charging is required to begin the download
                .setAllowedOverMetered(true)// Set if download is allowed on Mobile network
                .setAllowedOverRoaming(true);// Set if download is allowed on roaming network

        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        downloadID = downloadManager.enqueue(request);// enqueue puts the download request in the queue.
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(onDownloadComplete);
    }
}