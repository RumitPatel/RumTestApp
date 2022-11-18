package com.etl.rum.rumtestapp.timeZoneTest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.etl.rum.rumtestapp.R;

import java.util.Calendar;
import java.util.Date;

public class TimeZoneTestActivity extends AppCompatActivity {

    //Asia/Kolkata
    //Europe/London

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_timezone_test);

        setListeners();
    }

    private void setListeners() {
        findViewById(R.id.btnClickHere).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testTimeZone();
            }
        });
    }

    private void testTimeZone() {

        Calendar time = Calendar.getInstance();
        time.add(Calendar.MILLISECOND, -time.getTimeZone().getOffset(time.getTimeInMillis()));
        Date date = time.getTime();
    }
}