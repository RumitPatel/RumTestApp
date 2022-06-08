package com.etl.rum.rumtestapp.rotateWithScrollTest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.etl.rum.rumtestapp.R;

import java.util.ArrayList;
import java.util.List;

public class RotateWithScrollTestActivity extends AppCompatActivity {

    private final ArrayList<ImageView> mArrayListImageView = new ArrayList<>();
    private final OnMyScrollListener mOnMyScrollListener = new OnMyScrollListener() {

        @Override
        public void addViewForRotate(ImageView imageView) {
            mArrayListImageView.add(imageView);
        }
    };
    private Context mContext;
    private RecyclerView recyclerView;
    private ImageView imageViewTemp;
    private RotateTestAdapter mRotateTestAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_with_scroll);

        initComponents();
        setListener();
    }

    private void initComponents() {
        mContext = this;
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        mRotateTestAdapter = new RotateTestAdapter(mContext, getTempList(), mOnMyScrollListener);
        recyclerView.setAdapter(mRotateTestAdapter);

        imageViewTemp = findViewById(R.id.imageViewTemp);
    }

    private void setListener() {
        findViewById(R.id.btnClickHere).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                rotate(90);
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                Log.e("@***@***@", "dx = " + dx + ", dy = " + dy);
                rotate(2, dy);

            }
        });
    }

    private void rotate(float degree, int dy) {
        /*final RotateAnimation rotateAnim = new RotateAnimation(0.0f, degree,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotateAnim.setDuration(0);
        rotateAnim.setFillAfter(true);
        imageViewTemp.startAnimation(rotateAnim);*/

//        imageViewTemp.setRotation(degree);

        /*if(dy > 0) {
            imageViewTemp.setRotation(imageViewTemp.getRotation()- degree);
        } else {
            imageViewTemp.setRotation(imageViewTemp.getRotation()+ degree);
        }
*/
        for (int i = 0; i < mArrayListImageView.size(); i++) {
            if (dy > 0) {
                mArrayListImageView.get(i).setRotation(mArrayListImageView.get(i).getRotation() - degree);
            } else {
                mArrayListImageView.get(i).setRotation(mArrayListImageView.get(i).getRotation() + degree);
            }
        }

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