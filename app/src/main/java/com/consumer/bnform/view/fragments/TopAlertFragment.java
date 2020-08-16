package com.consumer.bnform.view.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.consumer.bnform.R;
import com.consumer.bnform.databinding.FragmentTopAlertBinding;


public class TopAlertFragment extends Fragment {

    private final static String TAG = TopAlertFragment.class.getSimpleName();

    private FragmentTopAlertBinding mBinding;

    private LinearLayoutManager linearLayoutManager;


    public TopAlertFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        mBinding = FragmentTopAlertBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();

        //initialize recyclerview

        //call view model

        //Set data on adapter

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        Log.i(TAG, "onViewCreated: AlertInfoFragment");
        super.onViewCreated(view, savedInstanceState);
    }

    private void initRecycleView(Context context){

       linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
    }
}