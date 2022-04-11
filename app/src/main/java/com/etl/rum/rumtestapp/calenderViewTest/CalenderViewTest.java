package com.etl.rum.rumtestapp.calenderViewTest;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.etl.rum.rumtestapp.R;

import java.util.Calendar;

/**
 * Created by FatehAli Asamadi on 12/1/2017.
 */

public class CalenderViewTest extends Activity {

    private CalendarView calendarView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_test);


        new Thread(new Runnable() {
            @Override
            public void run() {
                initCalender();
            }
        }).run();
    }

    private void initCalender() {
        calendarView = findViewById(R.id.calenderview);

        Calendar calEndDate = Calendar.getInstance();
        calEndDate.set(Calendar.DAY_OF_MONTH, (calEndDate.get(Calendar.DAY_OF_MONTH) + 7));

//        calendarView.setMinDate(System.currentTimeMillis() - 1000);
//        calendarView.setMaxDate(calEndDate.getTimeInMillis());

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
//                selectedDateString = year + "-" + (month + 1) + "-" + dayOfMonth;
//                callScheduleListInfos(selectedDateString);
            }
        });

        if ((Build.VERSION.SDK_INT) <= 19) {
            ViewGroup.LayoutParams parameters = calendarView.getLayoutParams();
            parameters.height = 500; //value in pixels
//            calendarView.setLayoutParams(parameters);
        }
    }
}