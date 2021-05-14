package com.example.smartfarmandroidapp.MVVM.RoomModel.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.smartfarmandroidapp.domain.Preferences;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface PreferencesDAO {
    @Insert
    void createPreferences(Preferences prefs);

    @Update
    void savePreferences(Preferences prefs);

    @Query("SELECT * FROM preferences_table WHERE userID = :id;")
    Flowable<List<Preferences>> getPreferences(int id);
}
