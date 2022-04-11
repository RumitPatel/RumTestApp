package com.etl.rum.rumtestapp.broadcastAndDialog;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;

import com.etl.rum.rumtestapp.R;

public class ChildActivity_2 extends ParentActivity {

    private Context mContext;
    private Button button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_button);

        initComponents();
        setListeners();
    }

    private void initComponents() {
        mContext = this;
        button1 = findViewById(R.id.button1);
        button1.setText("This is ChildActivity_2");
    }

    private void setListeners() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.buttonBroadCast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getString(R.string.broad_cast_key_common));
                intent.putExtra("message", "This is my message1!");
                LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
            }
        });
    }
}