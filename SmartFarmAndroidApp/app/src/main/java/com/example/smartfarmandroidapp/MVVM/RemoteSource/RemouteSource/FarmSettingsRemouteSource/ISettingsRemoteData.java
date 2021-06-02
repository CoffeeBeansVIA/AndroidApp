package com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.FarmSettingsRemouteSource;

import com.example.smartfarmandroidapp.Domain.FarmSettings.SensorSettings;

public interface ISettingsRemoteData {
    void getPreferences(int userID);
    void savePreferences(int sensorID, SensorSettings sensorSetting);
}
