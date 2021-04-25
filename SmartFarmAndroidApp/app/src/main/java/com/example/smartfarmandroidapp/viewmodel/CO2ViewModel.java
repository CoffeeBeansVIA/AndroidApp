package com.example.smartfarmandroidapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.smartfarmandroidapp.domain.CO2;
import com.example.smartfarmandroidapp.repository.CO2Repository;

import java.util.List;

public class CO2ViewModel extends ViewModel {

    private CO2Repository CO2repository;
    private float desiredCO2, CO2Min, CO2Max;

    public CO2ViewModel() {
        CO2repository = CO2Repository.getInstance();
        desiredCO2 = 0;
        CO2Min = 0;
        CO2Max = 0;
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

    public void updateThresholds(float desiredCO2, float CO2Min, float CO2Max) {}

    public void retrieveCO2Level(int i) {
        CO2repository.retrieveCO2Level(i);
    }

}
