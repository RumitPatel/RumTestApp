package com.etl.rum.rumtestapp.workManager.other;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.etl.rum.rumtestapp.workManager.NotificationUtils;

public class AppWidgetAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationUtils.setNotification(context, "my_title", String.valueOf(System.currentTimeMillis()));
    }
}