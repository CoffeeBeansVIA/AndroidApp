package com.example.smartfarmandroidapp.MVVM.Repository.Monitor;

import androidx.lifecycle.LiveData;

import com.example.smartfarmandroidapp.Domain.Preferences;

import java.util.List;

public interface ISettingsRepository {
    void savePreferences(Preferences preferences);
    LiveData<List<com.example.smartfarmandroidapp.Domain.Preferences>> getPreferences(int userID);
}
