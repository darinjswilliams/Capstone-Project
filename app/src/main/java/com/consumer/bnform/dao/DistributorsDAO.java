package com.consumer.bnform.dao;

import com.consumer.bnform.dto.Distributors;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface DistributorsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(List<Distributors> distributorsList);

    @Query("Select * from distributors where recallId = :recallId")
    List<Distributors> getDistributor(int recallId);

}
