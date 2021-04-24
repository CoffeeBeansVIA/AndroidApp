package com.example.smartfarmandroidapp.response;

import com.example.smartfarmandroidapp.domain.Humidity;

public class HumidityResponse {
    private int humidityValue;

    public Humidity getHumidity() {
        return new Humidity(humidityValue);
    }
}
