package com.consumer.bnform.view.fragments;

import android.icu.util.BuddhistCalendar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.consumer.bnform.R;
import com.consumer.bnform.databinding.FragmentAlertInfoBinding;


public class AlertInfoFragment extends Fragment {


    private final static String TAG = AlertInfoFragment.class.getSimpleName();
    private FragmentAlertInfoBinding mFragmentAlertInfoBinding;

    public static final String ARG_OBJ = "Alert";

    public AlertInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentAlertInfoBinding = FragmentAlertInfoBinding.inflate(inflater, container, false);
        View view = mFragmentAlertInfoBinding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        Log.i(TAG, "onViewCreated: AlertInfoFragment");
        ((TextView) view.findViewById(R.id.alert_info_text))
                .setText(Integer.toString(args.getInt(ARG_OBJ)));

        super.onViewCreated(view, savedInstanceState);
    }
}