package com.example.smartfarmandroidapp.MVVM.Repository.Monitor;

import android.app.Application;

import com.example.smartfarmandroidapp.Domain.FarmSettings.SensorSettings;
import com.example.smartfarmandroidapp.Domain.Preferences.Preferences_ROOM;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.MonitorRemouteSource.ISettingsRemoteData;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.MonitorRemouteSource.SettingsRemoteData;
import com.example.smartfarmandroidapp.MVVM.RoomModel.Models.Preferences.IPreferencesModel;

public class SettingsRepository implements ISettingsRepository {
    private IPreferencesModel model;
    private ISettingsRemoteData remoteData;

    public SettingsRepository(Application application) {
        remoteData = new SettingsRemoteData();
    }

    @Override
    public void savePreferences(Preferences_ROOM preferences) {
        remoteData.savePreferences(3, new SensorSettings(preferences.getDesiredCO2(), preferences.getDeviationCO2()));
        remoteData.savePreferences(2, new SensorSettings(preferences.getDesiredTemperature(), preferences.getDeviationTemperature()));
        remoteData.savePreferences(1, new SensorSettings(preferences.getDesiredHumidity(), preferences.getDeviationHumidity()));
    }

    @Override
    public void getPreferences(int userID) { remoteData.getPreferences(userID); }
}
