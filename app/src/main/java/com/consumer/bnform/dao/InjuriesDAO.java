package com.consumer.bnform.dao;

import com.consumer.bnform.dto.Distributors;
import com.consumer.bnform.dto.Injuries;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface InjuriesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(List<Injuries> injuriesList);

    @Query("Select * from injuries where recallId = :recallId")
    List<Injuries> getInjuries(int recallId);

}
