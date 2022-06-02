package com.etl.rum.rumtestapp.steggeredTest;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.etl.rum.rumtestapp.R;
import com.etl.rum.rumtestapp.javaBean.MyInfo;

import java.util.ArrayList;

public class RecyclerViewSteggeredAdapter extends Adapter<RecyclerViewSteggeredAdapter.MyViewHolder> {
    private ArrayList<MyInfo> mArrayListMyInfos = new ArrayList();
    private final OnItemClickMyListener mOnItemClickMyListener;

    public RecyclerViewSteggeredAdapter(ArrayList<MyInfo> arrayListMyInfos, OnItemClickMyListener onItemClickMyListener) {
        this.mArrayListMyInfos = arrayListMyInfos;
        this.mOnItemClickMyListener = onItemClickMyListener;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_steggered, parent, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.textViewName.setText(this.mArrayListMyInfos.get(position).getName());
        holder.cardView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RecyclerViewSteggeredAdapter.this.mOnItemClickMyListener.onItemClick(position);
            }
        });
    }

    public int getItemCount() {
        return this.mArrayListMyInfos.size();
    }

    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public interface OnItemClickMyListener {
        void onItemClick(int i);
    }

    static class MyViewHolder extends ViewHolder {
        private final CardView cardView;
        private final View mainViewCell;
        private final TextView textViewName;

        MyViewHolder(View itemView) {
            super(itemView);
            this.mainViewCell = itemView;
            this.textViewName = itemView.findViewById(R.id.textViewName);
            this.cardView = itemView.findViewById(R.id.cardView);
        }
    }
}