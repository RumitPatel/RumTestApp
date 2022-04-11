package com.etl.rum.rumtestapp.adapters;

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

public class RecyclerViewAdapter extends Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ArrayList<MyInfo> mArrayListMyInfos = new ArrayList();
    private OnItemClickMyListener mOnItemClickMyListener;

    public interface OnItemClickMyListener {
        void onItemClick(int i);
    }

    public static class MyViewHolder extends ViewHolder {
        private CardView cardView;
        private View mainViewCell;
        private TextView textViewName;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.mainViewCell = itemView;
            this.textViewName = itemView.findViewById(R.id.textViewName);
            this.cardView = itemView.findViewById(R.id.cardView);
        }
    }

    public RecyclerViewAdapter(ArrayList<MyInfo> arrayListMyInfos, OnItemClickMyListener onItemClickMyListener) {
        this.mArrayListMyInfos = arrayListMyInfos;
        this.mOnItemClickMyListener = onItemClickMyListener;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textViewName.setText(this.mArrayListMyInfos.get(position).getName());
        holder.cardView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RecyclerViewAdapter.this.mOnItemClickMyListener.onItemClick(position);
            }
        });
    }

    public int getItemCount() {
        return this.mArrayListMyInfos.size();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
