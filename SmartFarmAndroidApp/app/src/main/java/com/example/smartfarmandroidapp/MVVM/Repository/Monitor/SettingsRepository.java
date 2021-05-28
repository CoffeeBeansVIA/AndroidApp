package com.example.smartfarmandroidapp.MVVM.Repository.Monitor;

import android.app.Application;

import com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.MonitorRemouteSource.ISettingsRemoteData;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.MonitorRemouteSource.SettingsRemoteData;
import com.example.smartfarmandroidapp.MVVM.RoomModel.Models.Preferences.IPreferencesModel;
import com.example.smartfarmandroidapp.domain.Preferences;

public class SettingsRepository implements ISettingsRepository {
    private IPreferencesModel model;
    private ISettingsRemoteData remoteData;

    public SettingsRepository(Application application) {
        //model = new PreferencesModel(application);
        remoteData = new SettingsRemoteData();
    }

    @Override
    public void savePreferences(Preferences preferences) {
        model.savePreferences(preferences);
    }

    @Override
    public void getPreferences(int userID) { remoteData.getPreferences(userID); }
}
