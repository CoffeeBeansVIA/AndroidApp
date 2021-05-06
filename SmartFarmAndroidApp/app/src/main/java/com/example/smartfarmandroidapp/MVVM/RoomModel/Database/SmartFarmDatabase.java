package com.example.smartfarmandroidapp.MVVM.RoomModel.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.smartfarmandroidapp.Domain.Room.Settings;
import com.example.smartfarmandroidapp.MVVM.RoomModel.DAO.FarmSettingsDAO;

@Database(entities = {Settings.class}, version = 1, exportSchema = false)
public abstract class SmartFarmDatabase extends RoomDatabase {
    private static SmartFarmDatabase instance;
    public abstract FarmSettingsDAO preferencesDAO();

    public static synchronized SmartFarmDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    SmartFarmDatabase.class, "smart_farm_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
