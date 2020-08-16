package com.consumer.bnform.dao;

import com.consumer.bnform.dto.Product;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ProductsDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(List<Product> productList);

    @Query("Select * from products where RecallID = :recallId")
    List<Product> getProduct(int recallId);

}
