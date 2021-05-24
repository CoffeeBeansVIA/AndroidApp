package com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator;

import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints.CO2API;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints.HumidityAPI;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints.PreferencesAPI;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints.TemperatureAPI;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.ServiceGenerator.ServiceGenerator;

import retrofit2.Retrofit;

public class MonitorGenerator implements IMonitorGenerator{
    private static CO2API co2API;
    private static HumidityAPI humidityAPI;
    private static TemperatureAPI temperatureAPI;
    private static PreferencesAPI preferencesAPI;
    private Retrofit.Builder baseRetrofitBuilder;

    public MonitorGenerator() {
        baseRetrofitBuilder = ServiceGenerator.getInstance();
    }

    @Override
    public CO2API getCo2API() {
        if (co2API == null) {
            co2API = baseRetrofitBuilder
                    .build()
                    .create(CO2API.class);
        }
        return co2API;
    }

    @Override
    public HumidityAPI getHumidityApi() {
        if (humidityAPI == null) {
            humidityAPI = baseRetrofitBuilder
                    .build()
                    .create(HumidityAPI.class);
        }
        return humidityAPI;
    }

    @Override
    public TemperatureAPI getTemperatureAPI() {
        if (temperatureAPI == null) {
            temperatureAPI = baseRetrofitBuilder
                    .build()
                    .create(TemperatureAPI.class);
        }
        return temperatureAPI;
    }

    @Override
    public PreferencesAPI getPreferencesAPI() {
        if (preferencesAPI == null) {
            preferencesAPI = baseRetrofitBuilder
                    .build()
                    .create(PreferencesAPI.class);
        }
        return preferencesAPI;
    }
}
