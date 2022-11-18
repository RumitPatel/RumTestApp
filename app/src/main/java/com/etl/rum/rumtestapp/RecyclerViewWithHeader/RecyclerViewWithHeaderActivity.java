package com.etl.rum.rumtestapp.RecyclerViewWithHeader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.etl.rum.rumtestapp.R;

import java.util.ArrayList;

public class RecyclerViewWithHeaderActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_with_header);

        recyclerView = findViewById(R.id.my_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MyRecyclerAdapter(getList());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<ListItem> getList() {
        ArrayList<ListItem> arrayList = new ArrayList<>();
        for (int j = 0; j <= 40; j++) {
            Header header = new Header();
            header.setHeader("header" + j);
            arrayList.add(header);
            for (int i = 0; i <= 3; i++) {
                ListItem item = new ListItem();
                item.setId(i);
                item.setName("A" + i);
                arrayList.add(item);
            }
        }
        return arrayList;
    }
}