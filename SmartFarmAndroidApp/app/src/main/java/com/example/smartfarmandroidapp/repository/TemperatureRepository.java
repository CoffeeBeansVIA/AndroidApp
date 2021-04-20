package com.example.smartfarmandroidapp.repository;

import androidx.lifecycle.LiveData;

import com.example.smartfarmandroidapp.domain.Temperature;
import com.example.smartfarmandroidapp.model.TemperatureDAO;

import java.util.List;

public class TemperatureRepository {

    private TemperatureDAO temperatureDAO;
    private static TemperatureRepository instance;

    private TemperatureRepository(){
        temperatureDAO = TemperatureDAO.getInstance();
    }

    public static TemperatureRepository getInstance(){
        if(instance == null)
            instance = new TemperatureRepository();

        return instance;
    }

    public LiveData<List<Temperature>> getAllTemperatureLevels(){
        return temperatureDAO.getAllTemperatureLevels();
    }

    public void insert(Temperature temperature) {
        temperatureDAO.insert(temperature);
    }

    public void deleteAllTemperatureLevels(){
        temperatureDAO.deleteAllTemperatureLevels();
    }
}
