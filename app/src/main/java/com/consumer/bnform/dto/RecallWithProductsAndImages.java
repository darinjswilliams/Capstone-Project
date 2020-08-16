package com.consumer.bnform.dto;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;

public class RecallWithProductsAndImages {

    @Embedded
    public Recall recall;

    @Relation(
            parentColumn = "recallId",
            entityColumn = "recallId",
            entity = Product.class
    )
    public List<Product> productList;

    @Relation(
            parentColumn = "recallId",
            entityColumn = "recallId",
            entity = Images.class
    )
    public List<Images> imagesList;
}
