package com.consumer.bnform.viewmodel;

import android.app.Application;

import com.consumer.bnform.dto.RecallWithInjuriesAndImagesAndProducts;
import com.consumer.bnform.network.AppRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class AlertLowViewModel extends AndroidViewModel {

    private static final String TAG = AlertsInfoViewModel.class.getSimpleName();

    private AppRepository appRepo;
    private LiveData<List<RecallWithInjuriesAndImagesAndProducts>> mRecallWithInjuriesAndImagesAndProducts;

    public AlertLowViewModel(@NonNull Application application){
        super(application);

        appRepo = AppRepository.getInstance(this.getApplication());
        mRecallWithInjuriesAndImagesAndProducts = appRepo.getRecallWithInjuriesAndImagesAndProducts();
    }

    public LiveData<List<RecallWithInjuriesAndImagesAndProducts>> getRecallWithInjuriesAndImagesAndProducts(){
        return mRecallWithInjuriesAndImagesAndProducts;
    }
}
