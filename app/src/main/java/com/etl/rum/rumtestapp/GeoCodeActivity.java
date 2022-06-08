package com.etl.rum.rumtestapp;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.etl.rum.rumtestapp.temp.AppUtils;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GeoCodeActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_code);

        mContext = this;

        setListeners();
    }

    private void setListeners() {
        findViewById(R.id.btnClickHere).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAddressFromLatLong();
            }
        });
    }

    private void getAddressFromLatLong() {
        double tempLat = 22.2587;
        double tempLong = 71.1924;

        try {
            Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(tempLat, tempLong, 5);
            for (int i = 0; i < addresses.size(); i++) {
                AppUtils.printLogE(addresses.get(i).getPostalCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}