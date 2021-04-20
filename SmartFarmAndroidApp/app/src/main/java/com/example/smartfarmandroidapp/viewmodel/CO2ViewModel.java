package com.example.smartfarmandroidapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.smartfarmandroidapp.model.CO2;
import com.example.smartfarmandroidapp.repository.CO2Repository;

import java.util.List;

public class CO2ViewModel extends ViewModel {

    private CO2Repository CO2repository;
    private int minCO2, maxCO2;

    public CO2ViewModel() {
        CO2repository = CO2Repository.getInstance();
        minCO2 = 0;
        maxCO2 = 0;
    }

    public LiveData<List<CO2>> getAllCO2Levels() {
        return CO2repository.getAllCO2Levels();
    }

    public void insert(final CO2 CO2) {
        CO2repository.insert(CO2);
    }

    public void deleteAllCO2Levels() {
        CO2repository.deleteAllCO2Levels();
    }
}
