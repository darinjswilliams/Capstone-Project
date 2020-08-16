package com.consumer.bnform.viewmodel;

import com.consumer.bnform.dto.RecallWithProductsAndImages;
import com.consumer.bnform.network.AppRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;


public class AlertsInfoViewModel {

    private static final String TAG = AlertsInfoViewModel.class.getSimpleName();
    private LiveData<List<RecallWithProductsAndImages>> mRecallWithProductsAndImages;

    public AlertsInfoViewModel(@NonNull AppRepository appRepository, int recallId){
        mRecallWithProductsAndImages = appRepository.getRecallWithProductsAndImages(recallId);
    }

    public LiveData<List<RecallWithProductsAndImages>> getRecallWithProductsAndImages(){
        return mRecallWithProductsAndImages;
    }

}
