package com.example.smartfarmandroidapp.shared;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.smartfarmandroidapp.model.Temperature;

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
