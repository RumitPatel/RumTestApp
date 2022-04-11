package com.etl.rum.rumtestapp.tabFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etl.rum.rumtestapp.R;

public class FragmentThree extends Fragment {
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(getActivity().getClass().getSimpleName(), "onCreateView FragmentThree");
        return inflater.inflate(R.layout.fragment_three, container, false);
    }
}
