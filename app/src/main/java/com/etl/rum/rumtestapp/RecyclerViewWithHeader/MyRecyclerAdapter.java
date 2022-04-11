package com.etl.rum.rumtestapp.RecyclerViewWithHeader;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.etl.rum.rumtestapp.R;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private List<ListItem> mHeaderItems;

    MyRecyclerAdapter(List<ListItem> headerItems) {
        this.mHeaderItems = headerItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);
            return new VHHeader(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
            return new VHItem(v);
        }
        // return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof VHHeader) {
            // VHHeader VHheader = (VHHeader)holder;
            Header currentItem = (Header) mHeaderItems.get(position);
            VHHeader VHheader = (VHHeader) holder;
            VHheader.txtTitle.setText(currentItem.getHeader());
        } else if (holder instanceof VHItem) {
            ContentItem currentItem = (ContentItem) mHeaderItems.get(position);
            VHItem VHitem = (VHItem) holder;
            VHitem.txtName.setText(currentItem.getName());
        }
    }

    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {

        return mHeaderItems.get(position) instanceof Header;

    }

    @Override
    public int getItemCount() {
        return mHeaderItems.size();
    }

    class VHHeader extends RecyclerView.ViewHolder {
        TextView txtTitle;

        VHHeader(View itemView) {
            super(itemView);
            this.txtTitle = itemView.findViewById(R.id.txtHeader);
        }
    }

    class VHItem extends RecyclerView.ViewHolder {
        TextView txtName;

        VHItem(View itemView) {
            super(itemView);
            this.txtName = itemView.findViewById(R.id.txtName);
        }
    }
}