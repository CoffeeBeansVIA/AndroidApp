package com.example.smartfarmandroidapp.MVVM.RoomModel.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.example.smartfarmandroidapp.Domain.Preferences.Preferences_ROOM;

import java.util.List;

@Dao
public interface PreferencesDAO {
    @Update
    void savePreferences(Preferences_ROOM prefs);

    @Query("SELECT * FROM preferences_table WHERE userID = :id;")
    List<Preferences_ROOM> getPreferences(int id);
}
