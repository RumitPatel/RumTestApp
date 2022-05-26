package com.etl.rum.rumtestapp.tabFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.etl.rum.rumtestapp.R;
import com.etl.rum.rumtestapp.adapters.RecyclerViewAdapter;
import com.etl.rum.rumtestapp.adapters.RecyclerViewAdapter.OnItemClickMyListener;
import com.etl.rum.rumtestapp.temp.TempData;

public class FragmentOne extends Fragment {
    private final OnItemClickMyListener mOnItemClickMyListener = new mOnItemClickMyListener();
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        Log.e(getActivity().getClass().getSimpleName(), "onCreateView FragmentOne");
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter(TempData.getInstance().getTempStringArray2(), this.mOnItemClickMyListener));
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new mOnRefreshListener());
        return view;
    }

    class mOnRefreshListener implements OnRefreshListener {

        mOnRefreshListener() {
        }

        public void onRefresh() {
            System.out.println("onRefresh() called");
            new Thread(new mRunnable()).start();
        }

        class mRunnable implements Runnable {

            mRunnable() {
            }

            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                FragmentOne.this.getActivity().runOnUiThread(new C02301());
            }

            class C02301 implements Runnable {
                C02301() {
                }

                public void run() {
                    FragmentOne.this.swipeRefreshLayout.setRefreshing(false);
                }
            }
        }
    }

    private class mOnItemClickMyListener implements OnItemClickMyListener {
        mOnItemClickMyListener() {
        }

        public void onItemClick(int position) {
            Toast.makeText(FragmentOne.this.getActivity(), TempData.getInstance().getTempStringArray2().get(position).getName() + " selected", Toast.LENGTH_SHORT).show();
        }
    }
}