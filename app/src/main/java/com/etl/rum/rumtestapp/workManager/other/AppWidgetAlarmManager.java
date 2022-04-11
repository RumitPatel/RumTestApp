package com.etl.rum.rumtestapp.workManager.other;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;


import java.util.Calendar;

/**
 * Created by darshan on 21/3/17.
 */

public class AppWidgetAlarmManager {
    /**
     * Sets a daily recurring alarm that is to trigger that
     * 2 am device time.
     */
    public static void setAlarm(Context context) {
        context.getApplicationContext();

        PendingIntent pendingIntent = getPendingIntent(context);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 6);
        calendar.set(Calendar.SECOND, 0);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        assert alarmManager != null;
        alarmManager.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(),
                /*AlarmManager.INTERVAL_DAY*/60000L,
                pendingIntent
        );
    }

    /**
     * Cancels any previously set alarms of similar type.
     */
    public static void cancelAlarm(Context context) {
        context = context.getApplicationContext();
        ((AlarmManager) context.getSystemService(Context.ALARM_SERVICE))
                .cancel(getPendingIntent(context));
    }

    private static PendingIntent getPendingIntent(Context context) {
        Intent intent = new Intent(context, AppWidgetAlarmReceiver.class);
        intent.setAction(Constants.ACTION_WIDGET_UPDATE);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }
}