package com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator;

import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints.CO2API;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints.HumidityAPI;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints.PreferencesAPI;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints.TemperatureAPI;

public interface IMonitorGenerator {
     CO2API getCo2API();
     HumidityAPI getHumidityApi();
     TemperatureAPI getTemperatureAPI();
     PreferencesAPI getPreferencesAPI();

}
