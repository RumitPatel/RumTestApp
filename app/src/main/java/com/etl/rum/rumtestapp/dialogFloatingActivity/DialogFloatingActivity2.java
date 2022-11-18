package com.etl.rum.rumtestapp.dialogFloatingActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.etl.rum.rumtestapp.R;

public class DialogFloatingActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog_floating_2);
        this.setFinishOnTouchOutside(false);
    }
}