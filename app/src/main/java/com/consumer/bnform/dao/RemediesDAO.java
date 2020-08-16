package com.consumer.bnform.dao;

import com.consumer.bnform.dto.Distributors;
import com.consumer.bnform.dto.Remedies;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface RemediesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(List<Remedies> remediesList);

    @Query("Select * from remedies where recallId = :recallId")
    List<Remedies> getRemedies(int recallId);

}
