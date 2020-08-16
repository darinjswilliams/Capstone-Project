package com.consumer.bnform.network;

import com.consumer.bnform.dto.Recall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//Retrofit Data feed
public interface RecallApi {

    @GET(Constants.RECALL_FORMAT)
    Call<List<Recall>> getRecallProducts();

    @GET(Constants.RECALL_BY_DATE)
    Call<List<Recall>> getRecallProductsByDate();
}


