package com.consumer.bnform.dao;

import com.consumer.bnform.dto.Recall;
import com.consumer.bnform.dto.RecallWithDistributorsAndManufactures;
import com.consumer.bnform.dto.RecallWithImagesHazardRemedies;
import com.consumer.bnform.dto.RecallWithInjuriesAndImagesAndProducts;
import com.consumer.bnform.dto.RecallWithProductsAndImages;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface RecallDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(List<Recall> recall);


    @Transaction
    @Query("SELECT * FROM recall where recallId = :recallId ")
    LiveData<List<RecallWithDistributorsAndManufactures>> getRecallWithDistributorsAndManufactures(int recallId);

    @Transaction
    @Query("SELECT * FROM recall where recallId = :recallId ")
    LiveData<List<RecallWithImagesHazardRemedies>> getRecallWithImagesHazardRemedies(int recallId);


    @Transaction
    @Query("SELECT * FROM recall")
    LiveData<List<RecallWithInjuriesAndImagesAndProducts>> getRecallWithInjuriesAndImagesAndProducts();


    @Transaction
    @Query("SELECT * FROM recall where recallId = :recallId ")
    LiveData<List<RecallWithProductsAndImages>> getRecallWithProductsAndImagess(int recallId);

}
