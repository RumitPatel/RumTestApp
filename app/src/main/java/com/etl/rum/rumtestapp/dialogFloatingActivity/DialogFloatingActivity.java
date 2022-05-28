package com.etl.rum.rumtestapp.dialogFloatingActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.etl.rum.rumtestapp.R;

public class DialogFloatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_floating);

        findViewById(R.id.btnClickHere).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DialogFloatingActivity2.class);
                startActivity(intent);
            }
        });
    }
}
