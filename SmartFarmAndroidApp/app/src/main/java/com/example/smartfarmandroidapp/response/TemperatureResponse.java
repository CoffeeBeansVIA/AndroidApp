package com.example.smartfarmandroidapp.response;

import com.example.smartfarmandroidapp.domain.Temperature;

public class TemperatureResponse {
    private int temperatureValue;

    public Temperature getTemperature() {
        return new Temperature(temperatureValue);
    }
}
