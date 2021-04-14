package com.example.smartfarmandroidapp.shared;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.smartfarmandroidapp.model.Humidity;

import java.util.ArrayList;
import java.util.List;

public class HumidityDAO {
    private MutableLiveData<List<Humidity>> allHumidityLevels;
    private static HumidityDAO instance;

    private HumidityDAO() {
        allHumidityLevels = new MutableLiveData<>();
        List<Humidity> newList = new ArrayList<>();
        allHumidityLevels.setValue(newList);
    }

    public static HumidityDAO getInstance() {
        if (instance == null) {
            instance = new HumidityDAO();
        }
        return instance;
    }

    public LiveData<List<Humidity>> getAllHumidityLevels() {
        return allHumidityLevels;
    }

    public void insert(Humidity humidity) {
        List<Humidity> currentHumidityLevel = allHumidityLevels.getValue();
        currentHumidityLevel.add(humidity);
        allHumidityLevels.setValue(currentHumidityLevel);
    }

    public void deleteAllHumidityLevels() {
        List<Humidity> newList = new ArrayList<>();
        allHumidityLevels.setValue(newList);
    }
}
