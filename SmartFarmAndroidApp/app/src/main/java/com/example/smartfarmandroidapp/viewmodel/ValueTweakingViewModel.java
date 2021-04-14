package com.example.smartfarmandroidapp.viewmodel;

import androidx.lifecycle.ViewModel;

public class ValueTweakingViewModel extends ViewModel {
    int co2Min, co2Max, temperatureMin, temperatureMax, humidityMin, humidityMax;

    public ValueTweakingViewModel() {
        co2Min = 0;
        co2Max = 0;
        temperatureMin = 0;
        temperatureMax = 0;
        humidityMin = 0;
        humidityMax = 0;
    }

    public void updateValues(int co2Min, int co2Max, int temperatureMin, int temperatureMax, int humidityMin, int humidityMax) {
        this.co2Min = co2Min;
        this.co2Max = co2Max;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.humidityMin = humidityMin;
        this.humidityMax = humidityMax;
    }
}
