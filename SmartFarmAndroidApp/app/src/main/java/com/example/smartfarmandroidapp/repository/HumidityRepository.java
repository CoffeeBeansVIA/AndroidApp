package com.example.smartfarmandroidapp.repository;

import androidx.lifecycle.LiveData;

import com.example.smartfarmandroidapp.domain.Humidity;
import com.example.smartfarmandroidapp.model.HumidityDAO;

import java.util.List;

public class HumidityRepository {
    private HumidityDAO humidityDAO;
    private static HumidityRepository instance;

    private HumidityRepository(){
        humidityDAO = HumidityDAO.getInstance();
    }

    public static HumidityRepository getInstance(){
        if(instance == null)
            instance = new HumidityRepository();

        return instance;
    }

    public LiveData<List<Humidity>> getAllHumidityLevels(){
        return humidityDAO.getAllHumidityLevels();
    }

    public void insert(Humidity humidity) {
        humidityDAO.insert(humidity);
    }

    public void deleteAllHumidityLevels(){
        humidityDAO.deleteAllHumidityLevels();
    }
}
