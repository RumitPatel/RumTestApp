package com.etl.rum.rumtestapp.broadcastAndDialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.etl.rum.rumtestapp.R;

public class BroadCastFromMultipleActivitiesTest extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_button);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BroadCastFromMultipleActivitiesTest.this, ChildActivity_1.class));
            }
        });
    }
}