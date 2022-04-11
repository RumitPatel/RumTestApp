package com.etl.rum.rumtestapp.workManager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.etl.rum.rumtestapp.R;

public class WorkManagerActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);

        mContext = this;

        setListeners();
    }

    private void setListeners() {
        findViewById(R.id.btn_start_work_manager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

/*                IntentFilter mTime = new IntentFilter(Intent.ACTION_TIME_TICK);
                MyBroadastReceiverse yourReceiver = new MyBroadastReceiverse();
                registerReceiver(yourReceiver, mTime);*/

            }
        });

        findViewById(R.id.btn_test_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationUtils.setNotification(mContext, "My Title", "My Message");
            }
        });
    }
}