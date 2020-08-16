package com.consumer.bnform.dao;

import com.consumer.bnform.dto.Distributors;
import com.consumer.bnform.dto.ManufacturerCountries;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ManufacturerCountriesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(List<ManufacturerCountries> manufacturerCountriesList);

    @Query("Select * from manufactuercountries where recallId = :recallId")
    List<ManufacturerCountries> getManufactuererCounties(int recallId);

}
