package com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.MonitorRemouteSource;

import com.example.smartfarmandroidapp.Domain.Sensors;

public interface ISettingsRemoteData {
    void getPreferences(int userID);
    void savePreferences(int sensorID, Sensors.SensorSettings sensorSetting);
}
