package com.etl.rum.rumtestapp.notificatoinHeadsUp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.etl.rum.rumtestapp.R;

import java.util.Random;

public class NotificationHeadsUpActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_heads_up);

        initComponents();
        setListeners();
    }

    private void initComponents() {
        mContext = this;
    }

    private void setListeners() {
        findViewById(R.id.btnClickHere).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationTest();
            }
        });
    }

    private void notificationTest() {
        Intent intent;
        intent = new Intent(this, NotificationHeadsUpActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isDisplayAlert", true);
        bundle.putString("NOTIFICATION_DATA", "data");
        intent.putExtras(bundle);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),
                new Random().nextInt(), intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_event)
                .setContentTitle("Title")
                .setContentText("Body")
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setOnlyAlertOnce(true)
                .setFullScreenIntent(pendingIntent, true);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationBuilder.setPriority(Notification.PRIORITY_HIGH);
        notificationBuilder.setVibrate(new long[0]);
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}