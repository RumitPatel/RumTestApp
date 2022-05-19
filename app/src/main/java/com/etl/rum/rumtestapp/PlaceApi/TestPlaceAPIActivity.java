package com.etl.rum.rumtestapp.PlaceApi;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.etl.rum.rumtestapp.R;
import com.etl.rum.rumtestapp.temp.AppUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class TestPlaceAPIActivity extends AppCompatActivity {

    private static final int PLACE_PICKER_REQUEST = 1001;
    private Context mContext;
    private TextView tvAddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_place_api);

        initComponents();
        setListener();
    }

    private void initComponents() {
        mContext = this;
        tvAddress = findViewById(R.id.tvAddress);
    }

    private void setListener() {
        findViewById(R.id.btnClickHere).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMapForGetAddress();
            }
        });
    }

    private void openMapForGetAddress() {
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

        try {
            startActivityForResult(builder.build(TestPlaceAPIActivity.this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(mContext, data);
                LatLng latLng = place.getLatLng();
                String address = String.format("Place: %s", place.getAddress());

                Geocoder geocoder = new Geocoder(this);
                try {
                    List<Address> listAddresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    String postCode = listAddresses.get(0).getPostalCode();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (!place.getAddress().toString().trim().equalsIgnoreCase("")) {
                    tvAddress.setText("lat:" + place.getLatLng().latitude + "\nlong:" + place.getLatLng().longitude + "\nAddress: " + place.getAddress().toString());

                    AppUtils.showToast(mContext, place.getAddress().toString());
                } else {
                    AppUtils.showToast(mContext, "Address is Empty, Please Select Address");
                }
            }
        }
    }
}