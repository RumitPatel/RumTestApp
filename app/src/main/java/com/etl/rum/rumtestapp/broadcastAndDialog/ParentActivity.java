package com.etl.rum.rumtestapp.broadcastAndDialog;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.etl.rum.rumtestapp.R;

public class ParentActivity extends AppCompatActivity {

    private Context mContext;
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("message");
            showDialog(message);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initComponents();
    }

    private void initComponents() {
        mContext = this;
    }

    protected void unRegistreBroadCast(Context context) {
        LocalBroadcastManager.getInstance(context).unregisterReceiver(mMessageReceiver);
    }

    protected void registreBroadCast(Context context) {
        LocalBroadcastManager.getInstance(context).registerReceiver(mMessageReceiver, new IntentFilter(getString(R.string.broad_cast_key_common)));
    }

    private void showDialog(String message) {
        final Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.dialog_xx);

        TextView tvMessage = dialog.findViewById(R.id.tv_message);
        tvMessage.setText(message);

        Button btnClose = dialog.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        unRegistreBroadCast(this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        registreBroadCast(this);
        super.onResume();
    }
}