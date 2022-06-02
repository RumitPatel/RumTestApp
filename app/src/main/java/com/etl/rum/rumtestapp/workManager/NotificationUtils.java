package com.etl.rum.rumtestapp.workManager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.etl.rum.rumtestapp.R;

public class NotificationUtils {

    private static NotificationManager notifManager;
    private static NotificationChannel mChannel;

    public static void setNotification(Context context, String title, String message) {
        if (notifManager == null) {
            notifManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Intent notificationIntent = new Intent(context, WorkManagerActivity.class);
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            String channelId = "01";
            if (mChannel == null) {
                String channelName = "Zencey";
                mChannel = new NotificationChannel(channelId, channelName, importance);
                mChannel.setDescription(message);
                mChannel.enableVibration(true);
                notifManager.createNotificationChannel(mChannel);
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId);

            PendingIntent pendingIntent = PendingIntent.getActivity(context, 1250, notificationIntent, PendingIntent.FLAG_ONE_SHOT);
            builder.setContentTitle(title)
                    .setSmallIcon(getNotificationIcon()) // required
                    .setContentText(message)  // required
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setSound(RingtoneManager.getDefaultUri
                            (RingtoneManager.TYPE_NOTIFICATION));
            Notification notification = builder.build();
            notifManager.notify(7773, notification);
        } else {
            Intent notificationIntent = new Intent(context, WorkManagerActivity.class);
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            int requestID = (int) System.currentTimeMillis();
            PendingIntent contentIntent = PendingIntent.getActivity(context, requestID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                    .setSmallIcon(getNotificationIcon())
                    .setContentTitle(title)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(message).setBigContentTitle(title).setSummaryText("Zencey notification"))
                    .setContentText(message).setAutoCancel(true);
            mBuilder.setSound(defaultSoundUri);
            mBuilder.setContentIntent(contentIntent);
            notifManager.notify(7773, mBuilder.build());
        }
    }

    private static int getNotificationIcon() {
        boolean useWhiteIcon = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP);
        return R.mipmap.ic_launcher;
    }
}
