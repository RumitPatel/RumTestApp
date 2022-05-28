package com.etl.rum.rumtestapp.timeZoneTest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.etl.rum.rumtestapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TimeZoneTestActvity extends AppCompatActivity {

    //Asia/Kolkata
    //Europe/London

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_timezone_test);

        setLisetners();
    }

    private void setLisetners() {
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



/*        long startDateIndia = 1519902331;
        long endDateIndia = 1519902294;

        long appointment1 = 1519901398;
        long appointment2 = 1519901426;
        long appointment3 = 1519901454;*/

        /*long startDateIndia = 1519902459;
        long endDateIndia = 1519902482;

        long appointment1 = 1519902514;
        long appointment2 = 1519902539;
        long appointment3 = 1519902571;

        if ((appointment1 > startDateIndia) &&
                (appointment1 < endDateIndia)) {
            AppUtils.printLogE("appointment1 success");
        } else {
            AppUtils.printLogE("appointment1 Fail");
        }

        if ((appointment2 > startDateIndia) &&
                (appointment2 < endDateIndia)) {
            AppUtils.printLogE("appointment2 success");
        } else {
            AppUtils.printLogE("appointment2 Fail");
        }

        if ((appointment3 > startDateIndia) &&
                (appointment3 < endDateIndia)) {
            AppUtils.printLogE("appointment3 success");
        } else {
            AppUtils.printLogE("appointment3 Fail");
        }*/



        /*Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        calendar.set(2018, Calendar.MARCH, 1, 00, 01);

        AppUtils.printLogE("calendar.getTime() = " + calendar.getTime());
        AppUtils.printLogE("calendar.getTimeInMillis() = " + calendar.getTimeInMillis());
        AppUtils.printLogE("calendar.getTimeZone().getID() = " + calendar.getTimeZone().getID());



        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        calendar2.set(2018, Calendar.MARCH, 1, 23, 30);

        AppUtils.printLogE("calendar2.getTime() = " + calendar2.getTime());
        AppUtils.printLogE("calendar2.getTimeInMillis() = " + calendar2.getTimeInMillis());
        AppUtils.printLogE("calendar.getTimeZone().getID() = " + calendar2.getTimeZone().getID());*/


        ArrayList<TimeInfo> arrayListTimeInfos = new ArrayList<>();

        /*Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.MARCH, 1, 23, 00);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/London"));

        AppUtils.printLogE("calendar.getTime() = " + calendar.getTime());
        AppUtils.printLogE("calendar.getTimeZone().getID() = " + calendar.getTimeZone().getID());
        AppUtils.printLogE("calendar.getTimeInMillis() = " + calendar.getTimeInMillis());
        TimeInfo timeInfo = new TimeInfo();
        timeInfo.setTimeMillis(calendar.getTimeInMillis());
        timeInfo.setTimeZoneId(calendar.getTimeZone().getID());
        timeInfo.setDateString(calendar.getTime().toString());
        arrayListTimeInfos.add(timeInfo);


        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2018, Calendar.MARCH, 1, 23, 30);
        calendar2.setTimeZone(TimeZone.getTimeZone("Europe/London"));

        AppUtils.printLogE("calendar2.getTime() = " + calendar2.getTime());
        AppUtils.printLogE("calendar2.getTimeZone().getID() = " + calendar2.getTimeZone().getID());
        AppUtils.printLogE("calendar2.getTimeInMillis() = " + calendar2.getTimeInMillis());
        timeInfo = new TimeInfo();
        timeInfo.setTimeMillis(calendar2.getTimeInMillis());
        timeInfo.setTimeZoneId(calendar2.getTimeZone().getID());
        timeInfo.setDateString(calendar2.getTime().toString());
        arrayListTimeInfos.add(timeInfo);


        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2018, Calendar.MARCH, 2, 01, 00);
        calendar3.setTimeZone(TimeZone.getTimeZone("Europe/London"));

        AppUtils.printLogE("calendar3.getTime() = " + calendar3.getTime());
        AppUtils.printLogE("calendar3.getTimeZone().getID() = " + calendar3.getTimeZone().getID());
        AppUtils.printLogE("calendar3.getTimeInMillis() = " + calendar3.getTimeInMillis());
        timeInfo = new TimeInfo();
        timeInfo.setTimeMillis(calendar3.getTimeInMillis());
        timeInfo.setTimeZoneId(calendar3.getTimeZone().getID());
        timeInfo.setDateString(calendar3.getTime().toString());
        arrayListTimeInfos.add(timeInfo);*/
    }
}