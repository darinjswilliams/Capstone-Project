package com.consumer.bnform.dao;

import com.consumer.bnform.dto.Distributors;
import com.consumer.bnform.dto.Manufacturers;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ManufacturesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(List<Manufacturers> manufacturersList);

    @Query("Select * from manufacturers where recallId = :recallId")
    List<Manufacturers> getManufacturers(int recallId);

}
