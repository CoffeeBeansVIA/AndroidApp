package com.example.smartfarmandroidapp.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.smartfarmandroidapp.domain.Preferences;

@Database(entities = {Preferences.class}, version = 1)
public abstract class PreferencesDatabase extends RoomDatabase {
    private static PreferencesDatabase instance;
    public abstract PreferencesDAO preferencesDAO();

    public static synchronized PreferencesDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    PreferencesDatabase.class, "preferences_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
