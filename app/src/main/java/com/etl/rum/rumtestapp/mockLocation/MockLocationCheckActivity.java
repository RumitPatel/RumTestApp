package com.etl.rum.rumtestapp.mockLocation;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.etl.rum.rumtestapp.R;

public class MockLocationCheckActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock_location_check);

        initComponents();
        setListeners();
    }

    private void initComponents() {
        mContext = this;
    }

    private void setListeners() {
        findViewById(R.id.btnCheckLocation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Mock Location : " + isMockSettingsON(mContext), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static boolean isMockSettingsON(Context context) {
        return !Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ALLOW_MOCK_LOCATION).equals("0");
    }
}