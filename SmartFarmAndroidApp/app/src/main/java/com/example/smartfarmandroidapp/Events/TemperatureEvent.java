package com.example.smartfarmandroidapp.Events;

import com.example.smartfarmandroidapp.domain.Temperature;

public class TemperatureEvent {
    private String temperature;

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTemperature(){
        return temperature;
    }
}
