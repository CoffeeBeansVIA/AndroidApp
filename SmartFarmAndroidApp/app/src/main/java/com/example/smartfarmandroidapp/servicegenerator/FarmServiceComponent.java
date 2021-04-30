package com.example.smartfarmandroidapp.servicegenerator;

import com.example.smartfarmandroidapp.webapi.CO2API;
import com.example.smartfarmandroidapp.webapi.HumidityAPI;
import com.example.smartfarmandroidapp.webapi.TemperatureAPI;

import dagger.Component;

// Definition of the Application graph
@Component
public interface FarmServiceComponent {
    CO2API getCO2API();
    HumidityAPI getHumidityAPI();
    TemperatureAPI getTemperatureAPI();
}
