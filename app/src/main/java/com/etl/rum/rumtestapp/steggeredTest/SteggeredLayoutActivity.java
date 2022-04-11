package com.etl.rum.rumtestapp.steggeredTest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.etl.rum.rumtestapp.R;
import com.etl.rum.rumtestapp.temp.TempData;

public class SteggeredLayoutActivity extends AppCompatActivity {

    private Context mContext;

    private RecyclerViewSteggeredAdapter.OnItemClickMyListener mOnItemClickMyListener = new RecyclerViewSteggeredAdapter.OnItemClickMyListener() {
        @Override
        public void onItemClick(int i) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steggered);

        initComponents();
    }

    private void initComponents() {
        mContext = this;

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        setStaggeredGridLayoutManager(mContext,recyclerView, 2);
        recyclerView.setAdapter(new RecyclerViewSteggeredAdapter(TempData.getInstanse().getTempStringArray(), mOnItemClickMyListener));
    }

    public static void setStaggeredGridLayoutManager(Context context, RecyclerView recyclerView, int count) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(count, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }
}