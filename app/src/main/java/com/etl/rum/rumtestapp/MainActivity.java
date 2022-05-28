package com.etl.rum.rumtestapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.etl.rum.rumtestapp.LocalizationTest.LocalizationTest;
import com.etl.rum.rumtestapp.NofificationVibration.NofificationVibrationActivity;
import com.etl.rum.rumtestapp.PlaceApi.TestPlaceAPIActivity;
import com.etl.rum.rumtestapp.RecyclerViewWithHeader.RecyclerViewWithHeaderActivity;
import com.etl.rum.rumtestapp.adapters.RecyclerViewAdapter;
import com.etl.rum.rumtestapp.broadcastAndDialog.BroadCastFromMultipleActivitiesTest;
import com.etl.rum.rumtestapp.dialogFloatingActivity.DialogFloatingActivity;
import com.etl.rum.rumtestapp.downloadWithProgress.DownloadWithNotificationProgress;
import com.etl.rum.rumtestapp.drawRoundOnFingerTouch.DrawRoundOnFingerTouchActivity;
import com.etl.rum.rumtestapp.ePrescriptionTest.EPrescriptionTestActivity;
import com.etl.rum.rumtestapp.fireStoreTest.FireStoreTestActivity;
import com.etl.rum.rumtestapp.googleSheetAccess.GoogleSheetAccessActivity;
import com.etl.rum.rumtestapp.locationAndPermissionTestActivity.LocationAndPermissionTestActivity;
import com.etl.rum.rumtestapp.mockLocation.MockLocationCheckActivity;
import com.etl.rum.rumtestapp.mpChart.MPChartActivity;
import com.etl.rum.rumtestapp.notificatoinHeadsUp.NotificationHeadsUpActivity;
import com.etl.rum.rumtestapp.qrCodeRead.QRCodeReadActivity;
import com.etl.rum.rumtestapp.reCaptchaTest.ReCaptchaTestActivity;
import com.etl.rum.rumtestapp.rotateWithScrollTest.RotateWithScrollTestActivity;
import com.etl.rum.rumtestapp.rotateWithScrollTest2.RotateWithScrollTestActivity2;
import com.etl.rum.rumtestapp.signInWithGoogle.SignInWithGoogleActivity;
import com.etl.rum.rumtestapp.speech_to_text.SpeechToTextActivity;
import com.etl.rum.rumtestapp.steggeredTest.SteggeredLayoutActivity;
import com.etl.rum.rumtestapp.tabActivities.IconTextTabsActivity;
import com.etl.rum.rumtestapp.tabActivities.TabScrollable;
import com.etl.rum.rumtestapp.tabActivities.TabSimple;
import com.etl.rum.rumtestapp.temp.TempData;
import com.etl.rum.rumtestapp.timeZoneTest.TimeZoneTestActvity;
import com.etl.rum.rumtestapp.webViewWIthPostDataTest.WebViewWithPostActivity;
import com.etl.rum.rumtestapp.workManager.WorkManagerActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final RecyclerViewAdapter.OnItemClickMyListener mOnItemClickMyListener = new OnItemClickMyListener();
    private Context mContext;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDeviceINfo();

        mContext = this;
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(new RecyclerViewAdapter(TempData.getInstance().getTempStringArray(), mOnItemClickMyListener));
        ActionBar ab = getSupportActionBar();
//        ab.setHomeAsUpIndicator((int) R.drawable.ic_menu);
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
        mDrawerLayout = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        View parentLayout = findViewById(android.R.id.content);
        Snackbar.make(parentLayout, "This is main activity", Snackbar.LENGTH_LONG)
                .setAction("CLOSE", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        testJSONData();
                    }
                })
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                .show();

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new MyOnNavigationItemSelectedListener());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fab) {
            openRouteGoogleMaps();
            testJSONData();
        }
    }

    private void openRouteGoogleMaps() {
        Uri.Builder directionsBuilder = new Uri.Builder()
                .scheme("https")
                .authority("www.google.com")
                .appendPath("maps")
                .appendPath("dir")
                .appendPath("")
                .appendQueryParameter("api", "1")
                .appendQueryParameter("origin", "28.7041" + "," + "77.1025")
                .appendQueryParameter("destination", "18.5204" + "," + "73.8567");

        startActivity(new Intent(Intent.ACTION_VIEW, directionsBuilder.build()));
    }

    private void testJSONData() {
        try {

            JSONObject jsonObjectMain = new JSONObject();

            JSONArray jsonArraySymptoms = new JSONArray();

            JSONObject jsonObjectSymptoms = new JSONObject();
            jsonObjectSymptoms.put("name", "GeneralSymptoms");
            JSONArray jsonArraySymptomNames = new JSONArray();
            jsonArraySymptomNames.put("Difficulty sleeping");
            jsonArraySymptomNames.put("Fatigue and Weakness");
            jsonObjectSymptoms.put("SymptomNames", jsonArraySymptomNames);
            jsonArraySymptoms.put(jsonObjectSymptoms);

            jsonObjectSymptoms = new JSONObject();
            jsonObjectSymptoms.put("name", "Head / Neck");
            jsonArraySymptomNames = new JSONArray();
            jsonArraySymptomNames.put("Congestion/Sinus Problem");
            jsonArraySymptomNames.put("Ear Pain");
            jsonObjectSymptoms.put("SymptomNames", jsonArraySymptomNames);
            jsonArraySymptoms.put(jsonObjectSymptoms);

            jsonObjectMain.put("symptoms_array", jsonArraySymptoms);

            Log.e("m_tag", "jsonObjectMain = \n" + jsonObjectMain);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("HardwareIds")
    private void showDeviceINfo() {
        Log.i("m_tag", "Settings.Secure.ANDROID_ID: " + Settings.Secure.ANDROID_ID);
        Log.i("m_tag", "SERIAL: " + Build.SERIAL);
        Log.i("m_tag", "MODEL: " + Build.MODEL);
        Log.i("m_tag", "ID: " + Build.ID);
        Log.i("m_tag", "Manufacture: " + Build.MANUFACTURER);
        Log.i("m_tag", "brand: " + Build.BRAND);
        Log.i("m_tag", "type: " + Build.TYPE);
        Log.i("m_tag", "user: " + Build.USER);
        Log.i("m_tag", "BASE: " + Build.VERSION_CODES.BASE);
        Log.i("m_tag", "INCREMENTAL " + Build.VERSION.INCREMENTAL);
        Log.i("m_tag", "SDK  " + Build.VERSION.SDK_INT);
        Log.i("m_tag", "BOARD: " + Build.BOARD);
        Log.i("m_tag", "HOST " + Build.HOST);
        Log.i("m_tag", "FINGERPRINT: " + Build.FINGERPRINT);
        Log.i("m_tag", "Version Code: " + Build.VERSION.RELEASE);
    }

    private class MyOnNavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {
        MyOnNavigationItemSelectedListener() {
        }

        public boolean onNavigationItemSelected(MenuItem menuItem) {
            menuItem.setChecked(true);
            mDrawerLayout.closeDrawers();
            return true;
        }
    }

    private class OnItemClickMyListener implements RecyclerViewAdapter.OnItemClickMyListener {
        OnItemClickMyListener() {
        }

        public void onItemClick(int position) {
            switch (position) {
                case 0:
                    startActivity(new Intent(mContext, TabSimple.class));
                    break;
                case 1:
                    startActivity(new Intent(mContext, TabScrollable.class));
                    break;
                case 2:
                    startActivity(new Intent(mContext, IconTextTabsActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(mContext, FireStoreTestActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(mContext, WebViewWithPostActivity.class));
                    break;
                case 5:
                    startActivity(new Intent(mContext, NotificationHeadsUpActivity.class));
                    break;
                case 27:
                    startActivity(new Intent(mContext, LocalizationTest.class));
                    break;
                case 28:
                    startActivity(new Intent(mContext, DialogFloatingActivity.class));
                    break;
                case 29:
                    startActivity(new Intent(mContext, BroadCastFromMultipleActivitiesTest.class));
                    break;
                case 30:
                    startActivity(new Intent(mContext, TimeZoneTestActvity.class));
                    break;
                case 31:
                    startActivity(new Intent(mContext, LocationAndPermissionTestActivity.class));
                    break;
                case 32:
                    startActivity(new Intent(mContext, ReCaptchaTestActivity.class));
                    break;
                case 33:
                    startActivity(new Intent(mContext, GeoCodeActivity.class));
                    break;
                case 34:
                    startActivity(new Intent(mContext, TestPlaceAPIActivity.class));
                    break;
                case 35:
                    startActivity(new Intent(mContext, MockLocationCheckActivity.class));
                    break;
                case 36:
                    startActivity(new Intent(mContext, RotateWithScrollTestActivity.class));
                    break;
                case 37:
                    startActivity(new Intent(mContext, RotateWithScrollTestActivity2.class));
                    break;
                case 38:
                    startActivity(new Intent(mContext, GoogleSheetAccessActivity.class));
                    break;
                case 39:
                    startActivity(new Intent(mContext, SteggeredLayoutActivity.class));
                    break;
                case 40:
                    startActivity(new Intent(mContext, RecyclerViewWithHeaderActivity.class));
                    break;
                case 41:
                    startActivity(new Intent(mContext, NofificationVibrationActivity.class));
                    break;
                case 42:
                    startActivity(new Intent(mContext, WorkManagerActivity.class));
                    break;
                case 43:
                    startActivity(new Intent(mContext, SpeechToTextActivity.class));
                    break;
                case 44:
//                    startActivity(new Intent(mContext, CNEtPayActivity.class));
                    break;
                case 45:
                    startActivity(new Intent(mContext, DownloadWithNotificationProgress.class));
                    break;
                case 46:
                    startActivity(new Intent(mContext, MPChartActivity.class));
                    break;
                case 47:
                    startActivity(new Intent(mContext, QRCodeReadActivity.class));
                    break;
                case 48:
                    startActivity(new Intent(mContext, SignInWithGoogleActivity.class));
                    break;
                case 49:
                    startActivity(new Intent(mContext, EPrescriptionTestActivity.class));
                    break;
                case 50:
                    startActivity(new Intent(mContext, DrawRoundOnFingerTouchActivity.class));
                    break;
                default:
                    break;
            }
        }
    }
}