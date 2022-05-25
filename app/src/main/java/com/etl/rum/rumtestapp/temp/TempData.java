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
        return new C02321();
    }

    public ArrayList<MyInfo> getTempStringArray2() {
        return new C02332();
    }

    static class C02332 extends ArrayList<MyInfo> {
        C02332() {
            for (int i = 0; i < 30; i++) {
                MyInfo myInfo = new MyInfo();
                myInfo.setName("name " + i);
                myInfo.setAddress("address " + i);
                add(myInfo);
            }
        }
    }

    private class C02321 extends ArrayList<MyInfo> {
        C02321() {
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
            myInfo.setName("only icon tabs");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("custom view tabs");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Nested Scroll test");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Abstract ListAdapter");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Matrix Test");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Matrix Tes2");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Test Usage of this keywork");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Test Logic");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Test Activity cycle");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Test BroadCastReceiver");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Test Paytm");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("CalenderView Load Test");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("FCM SMS Test");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("DirecPay Test");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Request Test");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("WebView Callback test");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Date Time Conversation");
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
            myInfo.setName("Facebook Auth with Firebase");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Stripe Test");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Notification Headsup test");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Test All");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Kotlin Test");
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
            myInfo.setName("Test Recaptcha");
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
            myInfo.setName("Steggered View");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("RecyclerView with header");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Notificatoin with vibrate");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("WorkManager Test");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Speech To Text");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("CInetPay");
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
            myInfo.setName("EPrescription Test");
            myInfo.setAddress("");
            add(myInfo);
            myInfo = new MyInfo();
            myInfo.setName("Draw round on finger touch Test");
            myInfo.setAddress("");
            add(myInfo);
        }
    }
}