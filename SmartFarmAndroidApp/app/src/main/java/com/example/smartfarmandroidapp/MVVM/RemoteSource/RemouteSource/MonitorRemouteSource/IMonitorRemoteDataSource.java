package com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.MonitorRemouteSource;

public interface IMonitorRemoteDataSource {
    void getCO2();

    void getHumidity();

    void getTemperature();

    void getPreferences();
}
