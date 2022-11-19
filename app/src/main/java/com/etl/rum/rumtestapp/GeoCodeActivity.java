package com.etl.rum.rumtestapp;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

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
        double tempLat = 23.0972046;
        double tempLong = 72.5404878;

        try {
            Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(tempLat, tempLong, 5);
            String addressString = "";
            for (int i = 0; i < addresses.size(); i++) {
                String index = (i+1)+"";
                addressString = !index.isEmpty() ? addressString + "\nindex: " + index + "\n" : addressString;
                String postalCode = addresses.get(i).getPostalCode();
                addressString = (postalCode != null && !postalCode.isEmpty()) ? (addressString + ("PostalCode: " + postalCode + "\n")) : addressString;
                String adminArea = addresses.get(i).getAdminArea();
                addressString = (adminArea != null && !adminArea.isEmpty()) ? (addressString + ("adminArea: " + adminArea + "\n")) : addressString;
                String subAdminArea = addresses.get(i).getSubAdminArea();
                addressString = (subAdminArea != null && !subAdminArea.isEmpty()) ? (addressString + ("subAdminArea: " + subAdminArea + "\n")) : addressString;
                String locality = addresses.get(i).getLocality();
                addressString = (locality != null && !locality.isEmpty()) ? (addressString + ("locality: " + locality + "\n")) : addressString;
                String subLocality = addresses.get(i).getSubLocality();
                addressString = (subLocality != null && !subLocality.isEmpty()) ? (addressString + ("PostalCode: " + subLocality + "\n")) : addressString;
            }

            if (!TextUtils.isEmpty(addressString)) {
                AppUtils.printLogE(addressString);
                ((TextView)findViewById(R.id.tvAddress)).setText(addressString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}