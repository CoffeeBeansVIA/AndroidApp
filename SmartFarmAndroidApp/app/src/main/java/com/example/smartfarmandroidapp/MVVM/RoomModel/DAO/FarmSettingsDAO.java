package com.example.smartfarmandroidapp.MVVM.RoomModel.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.smartfarmandroidapp.Domain.Room.Settings;

import java.util.List;

@Dao
public interface FarmSettingsDAO {
    @Insert
    void createPreferences(Settings prefs);

    @Update
    void savePreferences(Settings prefs);

    @Query("SELECT * FROM farm_settings_table WHERE userID = :id")
    LiveData<List<Settings>> getPreferences(int id);
}
