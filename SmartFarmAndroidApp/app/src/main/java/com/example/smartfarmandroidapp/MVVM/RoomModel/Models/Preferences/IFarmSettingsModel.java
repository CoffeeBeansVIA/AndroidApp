package com.example.smartfarmandroidapp.MVVM.RoomModel.Models.Preferences;

import androidx.lifecycle.LiveData;

import com.example.smartfarmandroidapp.Domain.Room.Settings;

import java.util.List;

public interface IFarmSettingsModel {
    void createSettings(Settings prefs);
    void saveSettings(Settings prefs);
    LiveData<List<Settings>> getSettings(int id);
}
