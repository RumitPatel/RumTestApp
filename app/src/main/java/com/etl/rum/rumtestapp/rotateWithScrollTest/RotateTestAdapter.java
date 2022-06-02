package com.etl.rum.rumtestapp.rotateWithScrollTest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.etl.rum.rumtestapp.R;

import java.util.List;

/**
 * Created by FatehAli Asamadi on 9/14/2017.
 * Adapter for doctors list
 */

public class RotateTestAdapter extends RecyclerView.Adapter<RotateTestAdapter.MyViewHolder> {

    private final Context mContext;
    private final List<DoctorInfo> mArrayListDoctorInfos;
    private final OnMyScrollListener mOnMyScrollListener;

    public RotateTestAdapter(Context context, List<DoctorInfo> arrayListDoctorInfos, OnMyScrollListener onMyScrollListener) {
        mContext = context;
        mArrayListDoctorInfos = arrayListDoctorInfos;
        mOnMyScrollListener = onMyScrollListener;
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

        mOnMyScrollListener.addViewForRotate(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mArrayListDoctorInfos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final LinearLayout linearLayout;
        private final TextView textView;
        private final ImageView imageView;

        MyViewHolder(View view) {
            super(view);

            linearLayout = view.findViewById(R.id.linearLayout);
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);

        }
    }
}