package com.example.smartfarmandroidapp.MVVM.RoomModel.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.smartfarmandroidapp.domain.Preferences;

import java.util.List;

@Dao
public interface PreferencesDAO {
    @Insert
    void createPreferences(Preferences prefs);

    @Update
    void savePreferences(Preferences prefs);

    @Query("SELECT * FROM preferences_table WHERE userID = :id;")
    LiveData<List<Preferences>> getPreferences(int id);
}
