package com.etl.rum.rumtestapp.temp;

import com.etl.rum.rumtestapp.javaBean.MyInfo;

import java.util.ArrayList;

public class TempData {
    private static TempData TEMP_DATA_OBJ = null;

    public static synchronized TempData getInstance() {
        TempData tempData;
        synchronized (TempData.class) {
            if (TEMP_DATA_OBJ != null) {
                tempData = TEMP_DATA_OBJ;
            } else {
                tempData = new TempData();
                TEMP_DATA_OBJ = tempData;
            }
        }
        return tempData;
    }

    public ArrayList<MyInfo> getTempStringArray() {
        return new MyArrayList();
    }

    public ArrayList<MyInfo> getTempStringArray2() {
        return new MyTempArray();
    }

    static class MyTempArray extends ArrayList<MyInfo> {
        MyTempArray() {
            for (int i = 0; i < 30; i++) {
                MyInfo myInfo = new MyInfo();
                myInfo.setName("name " + i);
                myInfo.setAddress("address " + i);
                add(myInfo);
            }
        }
    }

    private static class MyArrayList extends ArrayList<MyInfo> {
        MyArrayList() {
            MyInfo myInfo = new MyInfo();
            myInfo.setName("simple tabs");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("scrollable tabs");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("icon and text tabs");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("FireStore Test");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("WebView with Post data");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Notification HeadsUp test");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Localization Test");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Dialog Floating activity");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("BroadCastFromMultipleActivitiesTest");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Time Zone Test");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Location And Permission");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("GeoCode Test");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Place API test");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Mock Location test");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Rotate with scroll test");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Rotate with scroll test 2");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Access Google Sheet");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Staggered View");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("RecyclerView with header");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Notification with vibrate");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("WorkManager");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Speech To Text");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Download file with notification progress");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("MPChart Lib");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("QR Scan");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("SignIn with Google");
            myInfo.setAddress("");
            add(myInfo);

            myInfo = new MyInfo();
            myInfo.setName("Draw round on finger touch");
            myInfo.setAddress("");
            add(myInfo);
        }
    }
}