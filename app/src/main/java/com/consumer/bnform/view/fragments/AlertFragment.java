package com.consumer.bnform.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.consumer.bnform.R;
import com.consumer.bnform.adapter.AlertFragmentAdapter;
import com.consumer.bnform.databinding.FragmentAlertBinding;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;


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
        alertBinding.pager.setAdapter(mAlertFragmentAdapter);


        Log.i(TAG, "onViewCreated: ");

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                alertBinding.tabLayout, alertBinding.pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText(getResources().getString(R.string.critial_alert));
                        //TODO add icon
                        //tab.setIcon()
                        //call navigation to critical alert fragement
                        break;
                    case 1:
                        tab.setText(getResources().getString(R.string.moderate_alert));
                        //TODO add icon
                        //tab.setIcon()
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(view.getContext().getApplicationContext(), R.color.colorAccent )
                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(50);
                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                    case 2:
                        tab.setText(getResources().getString(R.string.low_alert));
                        //TODO add icon
                        //tab.setIcon()
                        break;
                }

            }
        }
        );

        tabLayoutMediator.attach();

        alertBinding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BadgeDrawable badgeDrawable = alertBinding.tabLayout.getTabAt(position).getOrCreateBadge();
                badgeDrawable.setVisible(false);
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        alertBinding = null;
    }
}