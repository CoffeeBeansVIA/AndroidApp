package com.example.smartfarmandroidapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.smartfarmandroidapp.domain.Humidity;
import com.example.smartfarmandroidapp.repository.HumidityRepository;

import java.util.List;

public class HumidityViewModel extends ViewModel {

    private HumidityRepository humidityRepository;
    private float desiredHumidity, humidityMin, humidityMax;

    public HumidityViewModel() {
        humidityRepository = HumidityRepository.getInstance();
        desiredHumidity = 0;
        humidityMin = 0;
        humidityMax = 0;
    }

    public LiveData<List<Humidity>> getAllHumidityLevels() {
        return humidityRepository.getAllHumidityLevels();
    }

    public void insert(final Humidity humidity) {
        humidityRepository.insert(humidity);
    }

    public void deleteAllHumidityLevels() {
        humidityRepository.deleteAllHumidityLevels();
    }

    public void updateThresholds(float desiredHumidity, float humidityMin, float humidityMax) {}
}
