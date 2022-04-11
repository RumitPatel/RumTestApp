package com.etl.rum.rumtestapp.dialogFloatingActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.etl.rum.rumtestapp.R;

/**
 * Created by FatehAli Asamadi on 24-Feb-18.
 * DialogFloatingActivity2
 */

public class DialogFloatingActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog_floating_2);
        this.setFinishOnTouchOutside(false);
    }
}