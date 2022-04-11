package com.etl.rum.rumtestapp.rotateWithScrollTest2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.etl.rum.rumtestapp.R;
import com.etl.rum.rumtestapp.rotateWithScrollTest.DoctorInfo;

import java.util.List;

/**
 * Created by FatehAli Asamadi on 9/14/2017.
 * Adapter for doctors list
 */

public class RotateTestAdapter2 extends RecyclerView.Adapter<RotateTestAdapter2.MyViewHolder> {

    private Context mContext;
    private List<DoctorInfo> mArrayListDoctorInfos;

    public RotateTestAdapter2(Context context, List<DoctorInfo> arrayListDoctorInfos) {
        Log.e("@***@***@", "Constuctor called");
        mContext = context;
        mArrayListDoctorInfos = arrayListDoctorInfos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final DoctorInfo doctorInfo = mArrayListDoctorInfos.get(position);
        holder.textView.setText(doctorInfo.getDoctorName());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Clicked " + position, Toast.LENGTH_SHORT).show();
            }
        });

        rotate(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mArrayListDoctorInfos.size();
    }

    private void rotate(ImageView imageView) {
        imageView.setRotation(MyModel.getDegrees());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearLayout;
        private TextView textView;
        private ImageView imageView;

        MyViewHolder(View view) {
            super(view);

            linearLayout = view.findViewById(R.id.linearLayout);
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);

        }
    }
}