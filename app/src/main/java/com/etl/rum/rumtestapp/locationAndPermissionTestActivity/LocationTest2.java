package com.etl.rum.rumtestapp.locationAndPermissionTestActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.etl.rum.rumtestapp.R;
import com.etl.rum.rumtestapp.temp.AppUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationTest2 extends AppCompatActivity {

    public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000; //The desired interval for location updates. Inexact. Updates may be more or less frequent.
    public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2; //The fastest rate for active location updates. Exact. Updates will never be more frequent than this value.
    protected static final int  REQUEST_CHECK_SETTINGS = 0x1;
    private static final int REQUEST_CODE_FOR_LOCATION = 1001;

    private Activity mActivity;
    private Context mContext;
    private TextView tvLatLng;

    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest mLocationRequest;

    private final LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            Location location = locationResult.getLastLocation();
            if (location != null) {
                AppUtils.printLogE("lat = " + location.getLatitude() + ", longitude = " + location.getLongitude());
                tvLatLng.setText(String.format("latitude = %s,\nlongitude = %s", location.getLatitude(), location.getLongitude() + "\n timestamp = " + System.currentTimeMillis()));
                Toast.makeText(mActivity, String.format("latitude = %s,\nlongitude = %s", location.getLatitude(), location.getLongitude() + "\n timestamp = " + System.currentTimeMillis()), Toast.LENGTH_SHORT).show();
                removeLocationCallback();
            } else {
                AppUtils.printLogE("Unabel To Get Locatoin...!!!");
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_test_2);

        mActivity = LocationTest2.this;
        mContext = this;

        tvLatLng = findViewById(R.id.tv_lat_long);

        setLisetners();
        prepareLocationRequest();
    }

    private void setLisetners() {
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAndRequestPermissions()) {
                    checkGPSEnabled();
                }
            }
        });
    }

    private boolean checkAndRequestPermissions() {
        int permissionFineLocation = ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION);
        int permissionCorceLocation = ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION);

        List<String> listPermissionsNeeded = new ArrayList<>();
        if (permissionFineLocation != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (permissionCorceLocation != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        if (!listPermissionsNeeded.isEmpty()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_CODE_FOR_LOCATION);
            }
            return false;
        }

        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_FOR_LOCATION: {
                Map<String, Integer> perms = new HashMap<>();

                perms.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.ACCESS_COARSE_LOCATION, PackageManager.PERMISSION_GRANTED);

                if (grantResults.length > 0) {
                    for (int i = 0; i < permissions.length; i++)
                        perms.put(permissions[i], grantResults[i]);

                    if (perms.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        checkGPSEnabled();
                        return;
                    } else {
                        //*Some of the Permission is not granted*//*
                        if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.ACCESS_FINE_LOCATION) ||
                                ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                            //*Ask for permission with never ask again*//*
                            showDialogCameraGalleryReqiredPermission();
                        } else {
                            //*Force Never ask again denied*//*
                            showDialogGotoSetting();
                        }
                    }
                }
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void showDialogCameraGalleryReqiredPermission() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert!");
        builder.setMessage("Location  Permission Required for this app");

        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

                checkAndRequestPermissions();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showDialogGotoSetting() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permission Needed");
        builder.setMessage("Go to settings and permissions");

        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void prepareLocationRequest() {
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(UPDATE_INTERVAL_IN_MILLISECONDS)
                .setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
    }

    @SuppressLint("MissingPermission")
    private void requestForLocationUpdate() {
        if (mFusedLocationClient == null) {
            mFusedLocationClient = LocationServices.getFusedLocationProviderClient(mContext);
            mFusedLocationClient.requestLocationUpdates(mLocationRequest, locationCallback, null /* Looper */);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeLocationCallback();
    }

    private void removeLocationCallback() {
        if (isFinishing() && mFusedLocationClient != null)
            mFusedLocationClient.removeLocationUpdates(locationCallback);
    }

    private void checkGPSEnabled() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest);
        Task<LocationSettingsResponse> task = LocationServices.getSettingsClient(this).checkLocationSettings(builder.build());

        task.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
                try {
                    AppUtils.printLogE("GPS Is Enabled:");
                    LocationSettingsResponse response = task.getResult(ApiException.class); // // get location settings
                    AppUtils.printLogE("LocationSettingsResponse = " + response.toString());
                    requestForLocationUpdate();
                } catch (ApiException exception) {
                    switch (exception.getStatusCode()) {
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            // Location settings are not satisfied. But could be fixed by showing the
                            // user a dialog.
                            try {
                                AppUtils.printLogE("GPS Is Not Enabled, Opening Dialog");
                                // Cast to a resolvable exception.
                                ResolvableApiException resolvable = (ResolvableApiException) exception;
                                // Show the dialog by calling startResolutionForResult(),
                                // and check the result in onActivityResult().
                                resolvable.startResolutionForResult(mActivity, REQUEST_CHECK_SETTINGS);
                            } catch (IntentSender.SendIntentException e) {
                                // Ignore the error.
                            } catch (ClassCastException e) {
                                // Ignore, should be an impossible error.
                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            // Location settings are not satisfied. However, we have no way to fix the
                            // settings so we won't show the dialog.
                            AppUtils.printLogE("case" + LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE);
                            break;
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        LocationSettingsStates states = LocationSettingsStates.fromIntent(intent); // get location settings
        switch (requestCode) {
            case REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        // All required changes were successfully made
                        AppUtils.printLogE("GPS Is Enabled:");
                        requestForLocationUpdate();
                        break;
                    case Activity.RESULT_CANCELED:
                        AppUtils.printLogE("GPS Is Cancelled:");
                        break;
                    default:
                        break;
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }
}