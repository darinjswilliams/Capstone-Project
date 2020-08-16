package com.consumer.bnform.dao;

import com.consumer.bnform.dto.Distributors;
import com.consumer.bnform.dto.Importers;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


@Dao
public interface ImportersDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(List<Importers> importersList);

    @Query("Select * from importers where recallId = :recallId")
    List<Importers> getImporters(int recallId);

}
