package com.example.smartfarmandroidapp.servicegenerator;

import android.app.Application;

import com.example.smartfarmandroidapp.module.ApiModule;
import com.example.smartfarmandroidapp.module.AppModule;
import com.example.smartfarmandroidapp.webapi.ValueAPI;
import com.example.smartfarmandroidapp.webapi.HumidityAPI;
import com.example.smartfarmandroidapp.webapi.TemperatureAPI;

public class FarmServiceGenerator extends Application {
    private static ValueAPI valueAPI;
    private static HumidityAPI humidityAPI;
    private static TemperatureAPI temperatureAPI;

    private FarmServiceComponent mApiComponent;

    private static String url = "https://sep4api.azurewebsites.net/";

    public FarmServiceGenerator() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

      mApiComponent = DaggerFarmServiceComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule(url))
                .build();
    }

    public FarmServiceComponent getNetComponent() {
        return mApiComponent;
    }
}
