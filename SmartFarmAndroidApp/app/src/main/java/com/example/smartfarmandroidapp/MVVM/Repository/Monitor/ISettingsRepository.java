package com.example.smartfarmandroidapp.MVVM.Repository.Monitor;

import com.example.smartfarmandroidapp.domain.Preferences;

public interface ISettingsRepository {
    void savePreferences(Preferences preferences);
    void getPreferences(int userID);
}
