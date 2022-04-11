package com.etl.rum.rumtestapp.dateTimeConversation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.etl.rum.rumtestapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by FatehAli Asamadi on 1/29/2018.
 * DateTimeConverzationTestActivity
 */

public class DateTimeConverzationTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_converzation);
        setListeners();
    }

    private void setListeners() {
        findViewById(R.id.btnClickHere).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long timemillis = getTimeMillisFromDateString("04-02-2018");

                Date date = new Date(timemillis);
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(timemillis);
                System.out.println("day " + cal.get(Calendar.DAY_OF_MONTH));
                System.out.println("month " + cal.get(Calendar.MONTH));
                System.out.println("year " + cal.get(Calendar.YEAR));

            }
        });
    }

    public static long getTimeMillisFromDateString(String stringddMMyyyy) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date mDate = sdf.parse(stringddMMyyyy);

            return mDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}