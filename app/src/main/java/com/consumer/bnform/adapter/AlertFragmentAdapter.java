package com.consumer.bnform.adapter;

import android.os.Bundle;
import android.util.Log;

import com.consumer.bnform.view.fragments.AlertFragment;
import com.consumer.bnform.view.fragments.AlertInfoFragment;

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
        //TODO return items in recycler
        return 2;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment alertFragment = new AlertInfoFragment();
        Bundle args = new Bundle();

        Log.i(TAG, "createFragment:");

        //Alerts tabs
        args.putInt(AlertInfoFragment.ARG_OBJ, position + 1);
        alertFragment.setArguments(args);

        return alertFragment;
    }
}
