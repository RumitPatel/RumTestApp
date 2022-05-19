package com.etl.rum.rumtestapp.temp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class AppUtils {

    public static void printLogE(String message) {
        Log.e("m_tag", message);
    }

    public static void showToast(Context mContext, String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}