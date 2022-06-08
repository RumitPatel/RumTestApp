package com.etl.rum.rumtestapp.drawRoundOnFingerTouch;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.etl.rum.rumtestapp.R;

public class DrawRoundOnFingerTouchActivity extends AppCompatActivity {

    private Context mContext;
    private SimpleDrawingView mSimpleDrawingView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_round_on_finter_touch);

        initComponents();
        setListeners();
    }

    private void initComponents() {
        mContext = this;

        mSimpleDrawingView = findViewById(R.id.simpleDrawingView);

    }

    private void setListeners() {
        mSimpleDrawingView.setListener(new OnImageTouchListener() {
            @Override
            public void onImageTouch(float touchX, float touchY) {
                showDialog("You have clicked at:\ntouchX = " + touchX + "\n\ntouchY = " + touchY);
            }
        });
    }

    private void showDialog(String message) {
        new AlertDialog.Builder(mContext)
                .setTitle("Pain area clicked")
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })

                .show();
    }
}