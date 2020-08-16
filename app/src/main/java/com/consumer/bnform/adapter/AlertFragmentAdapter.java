package com.consumer.bnform.adapter;

import com.consumer.bnform.view.fragments.AlertInfoFragment;
import com.consumer.bnform.view.fragments.LowAlertFragment;
import com.consumer.bnform.view.fragments.TopAlertFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AlertFragmentAdapter extends FragmentStateAdapter {

    private static final String TAG = AlertFragmentAdapter.class.getSimpleName();

    public AlertFragmentAdapter(Fragment fm) {
        super(fm);
    }

    @Override
    public int getItemCount() {
        //Return tab count, place value in constant
        return 3;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch(position){
            case 0:
                return new TopAlertFragment();
            case 1:
                return new LowAlertFragment();
            default:
                return new AlertInfoFragment();
        }


    }


}
