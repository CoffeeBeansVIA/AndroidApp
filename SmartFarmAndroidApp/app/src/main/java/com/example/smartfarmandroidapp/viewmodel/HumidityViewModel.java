package com.example.smartfarmandroidapp.viewmodel;

import androidx.lifecycle.LiveData;

import com.example.smartfarmandroidapp.model.Humidity;
import com.example.smartfarmandroidapp.repository.HumidityRepository;

import java.util.List;

public class HumidityViewModel {

    private HumidityRepository humidityRepository;

    public HumidityViewModel() {
        humidityRepository = HumidityRepository.getInstance();
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
}
