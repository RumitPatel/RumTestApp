package com.etl.rum.rumtestapp.LocalizationTest;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.etl.rum.rumtestapp.R;

import java.util.Locale;

public class LocalizationTest extends AppCompatActivity {

    private static final String ENGLISH = "en";
    private static final String ARABIC = "ar";
    private Context mContext;
    private FloatingActionButton fab;
    private Spinner spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localization_test);

        initComponents();
        setListeners();
    }

    private void initComponents() {
        mContext = this;

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        fab = findViewById(R.id.fab);
        spinner = findViewById(R.id.spinner);
    }

    private void setListeners() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testLocalization();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Toast.makeText(mContext, "English Selected", Toast.LENGTH_SHORT).show();
//                    testLocalization(false);
                } else if (i == 1) {
                    Toast.makeText(mContext, "Arebic Selected", Toast.LENGTH_SHORT).show();
//                    testLocalization(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void testLocalization() {
        String language;
        Locale ll = Locale.getDefault();
        if (ll.getLanguage().equalsIgnoreCase(ARABIC)) {
            language = ENGLISH;
        } else {
            language = ARABIC;
        }

        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configEn = new Configuration();
        configEn.locale = locale;
        getApplicationContext().getResources().updateConfiguration(configEn, null);
        this.recreate();
    }
}