package com.etl.rum.rumtestapp.rotateWithScrollTest2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.etl.rum.rumtestapp.R;
import com.etl.rum.rumtestapp.rotateWithScrollTest.DoctorInfo;

import java.util.ArrayList;
import java.util.List;

public class RotateWithScrollTestActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RotateTestAdapter2 mRotateTestAdapter2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_with_scroll);

        initComponents();
        setListener();
    }

    private void initComponents() {
        Context mContext = this;
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        mRotateTestAdapter2 = new RotateTestAdapter2(mContext, getTempList());
        recyclerView.setAdapter(mRotateTestAdapter2);
    }

    private void setListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                MyModel.setIsRotationLeft(dy > 0);
                if (MyModel.getIsRotationLeft()) {
                    MyModel.setDegrees(MyModel.getDegrees() + 10);
                } else {
                    MyModel.setDegrees(MyModel.getDegrees() - 10);
                }

                mRotateTestAdapter2.notifyDataSetChanged();
            }
        });
    }

    private List<DoctorInfo> getTempList() {
        List<DoctorInfo> listDoctorInfos = new ArrayList<>();

        DoctorInfo doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Rumit 1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Shabbir 1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Rishil 1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Fateh 1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Mohammad android  1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("InamAli 1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("AbidAli 1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Kamiyab 1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Athar 1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Mohsin Designer 1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Mohsin Android 1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Chirag 1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Ahemad Abbas 1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Saaheb 1");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Rumit 21");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Shabbir 2");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Rishil 2");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Fateh 2");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Mohammad android  2");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("InamAli 2");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("AbidAli 2");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Kamiyab 2");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Athar 2");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Mohsin Designer 2");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Mohsin Android 2");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Chirag 2");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Ahemad Abbas 2");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Saaheb 2");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Rumit 3");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Shabbir 3");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Rishil 3");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Fateh 3");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Mohammad android  3");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("InamAli 3");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("AbidAli 3");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Kamiyab 3");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Athar 3");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Mohsin Designer 3");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Mohsin Android 3");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Chirag 3");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Ahemad Abbas 3");
        listDoctorInfos.add(doctorInfo);

        doctorInfo = new DoctorInfo();
        doctorInfo.setDoctorName("Saaheb 3");
        listDoctorInfos.add(doctorInfo);

        return listDoctorInfos;
    }
}