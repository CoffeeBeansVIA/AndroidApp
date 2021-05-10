package com.example.smartfarmandroidapp.MVVM.Repository.Monitor;

import androidx.lifecycle.LiveData;

import com.example.smartfarmandroidapp.domain.Preferences;

import java.util.List;

public interface ISettingsRepository {
    void savePreferences(Preferences preferences);
    LiveData<List<Preferences>> getPreferences(int userID);
}
