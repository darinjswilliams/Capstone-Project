package com.consumer.bnform.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.consumer.bnform.adapter.LowAlertAdapter;
import com.consumer.bnform.databinding.FragmentLowAlertBinding;
import com.consumer.bnform.dto.RecallWithInjuriesAndImagesAndProducts;
import com.consumer.bnform.viewmodel.AlertLowViewModel;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class LowAlertFragment extends Fragment implements LowAlertAdapter.OnItemClickListener {

    private static final String TAG = LowAlertFragment.class.getSimpleName();
    private FragmentLowAlertBinding mBinding;
    private LinearLayoutManager linearLayoutManager;
    private LowAlertAdapter lowAlertAdapter;
    private AlertLowViewModel mAlertLowViewModel;


    public LowAlertFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //Set data on adapter
        mBinding =  FragmentLowAlertBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();

        //initialize recyclerview
        initRecyclerView(view.getContext());

        //call view model
        mAlertLowViewModel = new ViewModelProvider(this).get(AlertLowViewModel.class);

        mAlertLowViewModel.getRecallWithInjuriesAndImagesAndProducts().observe(getViewLifecycleOwner(), recallProducts -> {
            Log.d(TAG, "onCreateView: size of products return.." + recallProducts.size());
            lowAlertAdapter.setRecallWithInjuriesAndImagesAndProducts(recallProducts);
        });

        return view;
    }

    private void initRecyclerView(Context context){
        Log.d(TAG, "initRecyclerView: ");
        linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        lowAlertAdapter = new LowAlertAdapter(this);

        //set layout manager on recycler view
        mBinding.alertLowRecyclerView.setLayoutManager(linearLayoutManager);

        //set adapter on recycler view
        mBinding.alertLowRecyclerView.setAdapter(lowAlertAdapter);
    }

    @Override
    public void onClick(RecallWithInjuriesAndImagesAndProducts mRecallWithInjuriesAndImagesAndProducts) {
        Log.d(TAG, "onClick: ");
    }
}