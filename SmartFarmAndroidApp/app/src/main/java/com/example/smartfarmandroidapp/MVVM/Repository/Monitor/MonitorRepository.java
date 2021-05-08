package com.example.smartfarmandroidapp.MVVM.Repository.Monitor;

import android.app.Application;

import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.IMonitorGenerator;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.MonitorRemouteSource.IMonitorRemoteDataSource;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.MonitorRemouteSource.MonitorRemoteDataSource;

public class MonitorRepository implements IMonitorRepository{

    private IMonitorRemoteDataSource monitorRemoteDataSource;
    //TODO add model here

    public MonitorRepository(Application application) {
       monitorRemoteDataSource = new MonitorRemoteDataSource();
    }

    @Override
    public void getCO2() {
         monitorRemoteDataSource.getCO2();
    }

    @Override
    public void getHumidity() {
         monitorRemoteDataSource.getHumidity();
    }

    @Override
    public void getTemperature() {
       monitorRemoteDataSource.getTemperature();
    }
}
