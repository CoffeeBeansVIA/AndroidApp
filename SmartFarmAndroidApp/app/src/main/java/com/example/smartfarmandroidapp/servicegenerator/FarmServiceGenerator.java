package com.example.smartfarmandroidapp.servicegenerator;

import com.example.smartfarmandroidapp.webapi.CO2API;
import com.example.smartfarmandroidapp.webapi.HumidityAPI;
import com.example.smartfarmandroidapp.webapi.TemperatureAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FarmServiceGenerator {
    private static CO2API co2API;
    private static HumidityAPI humidityAPI;
    private static TemperatureAPI temperatureAPI;

    public static CO2API getCO2API() {
        if (co2API == null) {
            co2API = new Retrofit.Builder()
                    .baseUrl("https://localhost:5001/swagger/index.html")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CO2API.class);
        }
        return co2API;
    }

    public static HumidityAPI getHumidityAPI() {
        if (humidityAPI == null) {
            humidityAPI = new Retrofit.Builder()
                    .baseUrl("https://localhost:5001/swagger/index.html")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(HumidityAPI.class);
        }
        return humidityAPI;
    }

    public static TemperatureAPI getTemperatureAPI() {
        if (temperatureAPI == null) {
            temperatureAPI = new Retrofit.Builder()
                    .baseUrl("https://localhost:5001/swagger/index.html")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(TemperatureAPI.class);
        }
        return temperatureAPI;
    }
}
