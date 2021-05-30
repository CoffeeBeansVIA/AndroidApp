package com.example.smartfarmandroidapp.MVVM.Repository.Monitor;

import android.app.Application;

import com.example.smartfarmandroidapp.Domain.Preferences;
import com.example.smartfarmandroidapp.Domain.Sensors;
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
    public void savePreferences(Preferences preferences) {
        remoteData.savePreferences(preferences.getCo2ID(), new Sensors.SensorSettings(preferences.getDesiredCO2(), preferences.getDeviationCO2()));
        remoteData.savePreferences(preferences.getTemperatureID(), new Sensors.SensorSettings(preferences.getDesiredTemperature(), preferences.getDeviationTemperature()));
        remoteData.savePreferences(preferences.getHumidityID(), new Sensors.SensorSettings(preferences.getDesiredHumidity(), preferences.getDeviationHumidity()));
    }

    @Override
    public void getPreferences(int userID) { remoteData.getPreferences(userID); }
}
