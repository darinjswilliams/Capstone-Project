package com.consumer.bnform.dao;

import com.consumer.bnform.dto.Distributors;
import com.consumer.bnform.dto.Retailers;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface RetailersDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(List<Retailers> retailersList);

    @Query("Select * from retailers where recallId = :recallId")
    List<Retailers> getRetailers(int recallId);

}
