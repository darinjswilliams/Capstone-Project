package com.consumer.bnform.network;

import android.content.Context;
import android.util.Log;

import com.consumer.bnform.dto.Images;
import com.consumer.bnform.dto.Product;
import com.consumer.bnform.dto.Recall;
import com.consumer.bnform.dto.RecallWithInjuriesAndImagesAndProducts;
import com.consumer.bnform.dto.RecallWithProductsAndImages;
import com.consumer.bnform.persistance.AppDatabase;
import com.consumer.bnform.persistance.AppExecutors;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AppRepository {

    private static final String TAG = AppRepository.class.getSimpleName();

    private static AppRepository ourInstance;
    private RecallApi mRecallApi;
    private Retrofit retrofit;
    private Call<List<Recall>> call;

    //Database Objects
    private List<Product> mProductList = new ArrayList<>();
    private List<Images> mImagesList  = new ArrayList<>();
    private List<Recall> mRecallList = new ArrayList<>();
    private AppDatabase appDatabase;
    private AppExecutors appExecutors;


    public static  AppRepository getInstance(Context context){
        if(ourInstance == null){
            ourInstance = new AppRepository(context.getApplicationContext());
        }
        return  ourInstance;
    }

    private AppRepository(Context context){
        retrofit = RetroFitClient.getClient();
        mRecallApi = retrofit.create(RecallApi.class);
        //TODO add appDatabase and appExececutor
        appDatabase = AppDatabase.getsInstance(context);
        appExecutors = AppExecutors.getInstance();
    }


    //** Retrofit Operations

    public void loadRecallProductsFromWeb(){

        //Parse with retrofit
        call = mRecallApi.getRecallProductsByDate();

        //Place in background thread
        call.enqueue(new Callback<List<Recall>>() {
            @Override
            public void onResponse(@NonNull Call<List<Recall>> call, @NonNull Response<List<Recall>> response) {

                Log.d(TAG, "onResponse: AppRepository Success");
                if(response.isSuccessful()){

                    List<Recall> recallList = response.body();
                    List<Product> productList = new ArrayList<>();
                     recallList.stream().forEach(recall -> productList.addAll(recall.getMProducts()));

                     List<Images> imageList = new ArrayList<>();
                        recallList.stream().forEach(imageItems -> imageList.addAll(imageItems.getMImage()));

                      //Populate class variables
                     mRecallList.addAll(recallList);
                     mImagesList.addAll(imageList);
                     mProductList.addAll(productList);

                     //Call database Operation
                     insertTask();
                }

            }

            @Override
            public void onFailure(Call<List<Recall>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    //Insert Objects into Database
    public void insertTask(){
        Log.d(TAG, "insertTask: ");
        appExecutors.mDbExecutor().execute(new Runnable() {
            @Override
            public void run() {

                //Recall List
                appDatabase.recallDAO().insertTask(mRecallList);

                //Images
                appDatabase.imagesDAO().insertTask(mImagesList);

                //Products
                appDatabase.productsDAO().insertTask(mProductList);
            }
        });
    }


    //RecalWithProductsAndImages
    public LiveData<List<RecallWithProductsAndImages>> getRecallWithProductsAndImages(int recallId){
        Log.d(TAG, "getRecallWithProductsAndImages: ");
        return appDatabase.recallDAO().getRecallWithProductsAndImagess(recallId);
    }

    public LiveData<List<RecallWithInjuriesAndImagesAndProducts>> getRecallWithInjuriesAndImagesAndProducts(){
        Log.d(TAG, "getRecallWithInjuriesAndImagesAndProducts: ");

        loadRecallProductsFromWeb();
        return appDatabase.recallDAO().getRecallWithInjuriesAndImagesAndProducts();
    }

}
