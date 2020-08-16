package com.consumer.bnform.persistance;

import android.content.Context;
import android.util.Log;

import com.consumer.bnform.dao.DistributorsDAO;
import com.consumer.bnform.dao.HazardsDAO;
import com.consumer.bnform.dao.ImagesDAO;
import com.consumer.bnform.dao.ImportersDAO;
import com.consumer.bnform.dao.InjuriesDAO;
import com.consumer.bnform.dao.ManufacturerCountriesDAO;
import com.consumer.bnform.dao.ManufacturesDAO;
import com.consumer.bnform.dao.ProductsDAO;
import com.consumer.bnform.dao.RecallDAO;
import com.consumer.bnform.dao.RemediesDAO;
import com.consumer.bnform.dao.RetailersDAO;
import com.consumer.bnform.dto.Distributors;
import com.consumer.bnform.dto.Hazards;
import com.consumer.bnform.dto.Images;
import com.consumer.bnform.dto.Importers;
import com.consumer.bnform.dto.Inconjuctions;
import com.consumer.bnform.dto.Injuries;
import com.consumer.bnform.dto.ManufacturerCountries;
import com.consumer.bnform.dto.Manufacturers;
import com.consumer.bnform.dto.Product;
import com.consumer.bnform.dto.ProductUPC;
import com.consumer.bnform.dto.Recall;
import com.consumer.bnform.dto.Remedies;
import com.consumer.bnform.dto.RemedyOptions;
import com.consumer.bnform.dto.Retailers;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

//ADD THE TYPE CONVERTERS SO ROOM KNOWS HOW TO DEAL WITH List CONVERSION
@Database(entities = {Distributors.class, Hazards.class, Images.class, Importers.class, Inconjuctions.class, Injuries.class, ManufacturerCountries.class,
Manufacturers.class, Product.class, ProductUPC.class, Recall.class, Remedies.class, RemedyOptions.class, Retailers.class}, version = 4,  exportSchema = false)
@TypeConverters(DateTypeConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "Bnform";
    private  static AppDatabase sInstance;

    public static AppDatabase getsInstance(Context context) {
        if(sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG,   "Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        //TODO -  Queries should be done in a separate thread to avoid locking the UI
                        //We will allow this only temporally to see that our db is working
                        //remove allowMainThreadQueries after verification.
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
        }

        Log.d(LOG_TAG, "GETTING DATABASE INSTANCE");
        return sInstance;
    }

    public abstract DistributorsDAO distributorsDAO();
    public abstract HazardsDAO hazardsDAO();
    public abstract ImagesDAO imagesDAO();
    public abstract ImportersDAO importersDAO();
    public abstract InjuriesDAO injuriesDAO();
    public abstract ManufacturerCountriesDAO manufacturerCountriesDAO();
    public abstract ManufacturesDAO manufacturesDAO();
    public abstract ProductsDAO productsDAO();
    public abstract RecallDAO recallDAO();
    public abstract RemediesDAO remediesDAO();
    public abstract RetailersDAO retailersDAO();
}
