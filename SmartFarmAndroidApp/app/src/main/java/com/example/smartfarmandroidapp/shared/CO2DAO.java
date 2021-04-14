package com.example.smartfarmandroidapp.shared;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.smartfarmandroidapp.model.CO2;

import java.util.ArrayList;
import java.util.List;

public class CO2DAO {

    private MutableLiveData<List<CO2>> allCO2Levels;
    private static CO2DAO instance;

    private CO2DAO() {
        allCO2Levels = new MutableLiveData<>();
        List<CO2> newList = new ArrayList<>();
        allCO2Levels.setValue(newList);
    }

    public static CO2DAO getInstance() {
        if (instance == null) {
            instance = new CO2DAO();
        }
        return instance;
    }

    public LiveData<List<CO2>> getAllCO2Levels() {
        return allCO2Levels;
    }

    public void insert(CO2 CO2) {
        List<CO2> currentCO2Level = allCO2Levels.getValue();
        currentCO2Level.add(CO2);
        allCO2Levels.setValue(currentCO2Level);
    }

    public void deleteAllCO2Levels() {
        List<CO2> newList = new ArrayList<>();
        allCO2Levels.setValue(newList);
    }
}
