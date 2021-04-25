package com.example.smartfarmandroidapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.smartfarmandroidapp.domain.Temperature;
import com.example.smartfarmandroidapp.repository.TemperatureRepository;

import java.util.List;

public class TemperatureViewModel extends ViewModel {

    private TemperatureRepository temperatureRepository;
    private float desiredTemperature, temperatureMin, temperatureMax;

    public TemperatureViewModel() {
        temperatureRepository = TemperatureRepository.getInstance();
        desiredTemperature = 0;
        temperatureMin = 0;
        temperatureMax = 0;
    }

    public LiveData<List<Temperature>> getAllTemperatureLevels() {
        return temperatureRepository.getAllTemperatureLevels();
    }

    public void insert(final Temperature temperature) {
        temperatureRepository.insert(temperature);
    }

    public void deleteAllTemperatureLevels() {
        temperatureRepository.deleteAllTemperatureLevels();
    }

    public void updateThresholds(float desiredTemperature, float temperatureMin, float temperatureMax) {}
}
