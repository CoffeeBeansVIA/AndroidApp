package com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.MonitorRemouteSource;

import com.example.smartfarmandroidapp.domain.Farm;

public interface ISettingsRemoteData {
    void getPreferences(int userID);
    void savePreferences(int sensorID, Farm.SensorSettings sensorSetting);
}
