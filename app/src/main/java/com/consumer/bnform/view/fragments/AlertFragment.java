package com.consumer.bnform.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.consumer.bnform.R;
import com.consumer.bnform.adapter.AlertFragmentAdapter;
import com.consumer.bnform.databinding.FragmentAlertBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class AlertFragment extends Fragment{

    private static final String TAG = AlertFragment.class.getSimpleName();

    ViewPager2 viewPager;
    AlertFragmentAdapter mAlertFragmentAdapter;
    FragmentAlertBinding alertBinding;

    //Empty constructor
    public AlertFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        alertBinding = FragmentAlertBinding.inflate(inflater, container, false);
        View view = alertBinding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        mAlertFragmentAdapter = new AlertFragmentAdapter(this);
//        viewPager = view.findViewById(R.id.pager);
        alertBinding.pager.setAdapter(mAlertFragmentAdapter);

//        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        Log.i(TAG, "onViewCreated: ");
        new TabLayoutMediator(alertBinding.tabLayout, alertBinding.pager,
                (tab, position) -> tab.setText("Alert " + position)).attach();


        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        alertBinding = null;
    }
}