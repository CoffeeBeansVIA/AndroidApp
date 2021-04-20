package com.example.smartfarmandroidapp.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.smartfarmandroidapp.domain.Temperature;

import java.util.ArrayList;
import java.util.List;

public class TemperatureDAO {

    private MutableLiveData<List<Temperature>> allTemperatureLevels;
    private static TemperatureDAO instance;

    private TemperatureDAO() {
        allTemperatureLevels = new MutableLiveData<>();
        List<Temperature> newList = new ArrayList<>();
        allTemperatureLevels.setValue(newList);
    }

    public static TemperatureDAO getInstance() {
        if (instance == null) {
            instance = new TemperatureDAO();
        }
        return instance;
    }

    public LiveData<List<Temperature>> getAllTemperatureLevels() {
        return allTemperatureLevels;
    }

    public void insert(Temperature temperature) {
        List<Temperature> currentTemperature = allTemperatureLevels.getValue();
        currentTemperature.add(temperature);
        allTemperatureLevels.setValue(currentTemperature);
    }

    public void deleteAllTemperatureLevels() {
        List<Temperature> newList = new ArrayList<>();
        allTemperatureLevels.setValue(newList);
    }
}
