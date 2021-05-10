package com.example.smartfarmandroidapp.MVVM.RoomModel.Models.Preferences;

import androidx.lifecycle.LiveData;

import com.example.smartfarmandroidapp.domain.Preferences;

import java.util.List;

public interface IPreferencesModel {
    void createPreferences(Preferences prefs);
    void savePreferences(Preferences prefs);
    LiveData<List<Preferences>> getPreferences(int id);
}
