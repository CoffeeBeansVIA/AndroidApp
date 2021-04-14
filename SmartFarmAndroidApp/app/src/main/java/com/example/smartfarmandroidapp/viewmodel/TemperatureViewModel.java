package com.example.smartfarmandroidapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.smartfarmandroidapp.model.Temperature;
import com.example.smartfarmandroidapp.repository.TemperatureRepository;

import java.util.List;

public class TemperatureViewModel extends ViewModel {

    private TemperatureRepository temperatureRepository;

    public TemperatureViewModel() {
        temperatureRepository = TemperatureRepository.getInstance();
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
}
