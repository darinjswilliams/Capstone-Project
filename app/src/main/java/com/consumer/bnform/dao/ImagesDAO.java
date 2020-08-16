package com.consumer.bnform.dao;

import com.consumer.bnform.dto.Distributors;
import com.consumer.bnform.dto.Images;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ImagesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(List<Images> imagesList);

    @Query("Select * from images where recallId = :recallId")
    List<Images> getImages(int recallId);

}
