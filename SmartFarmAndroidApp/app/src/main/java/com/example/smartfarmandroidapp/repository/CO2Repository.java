package com.example.smartfarmandroidapp.repository;

import androidx.lifecycle.LiveData;

import com.example.smartfarmandroidapp.domain.CO2;
import com.example.smartfarmandroidapp.model.CO2DAO;

import java.util.List;

public class CO2Repository {

    private CO2DAO CO2DAO;
    private static CO2Repository instance;

    private CO2Repository(){
        CO2DAO = CO2DAO.getInstance();
    }

    public static CO2Repository getInstance(){
        if(instance == null)
            instance = new CO2Repository();

        return instance;
    }

    public LiveData<List<CO2>> getAllCO2Levels(){
        return CO2DAO.getAllCO2Levels();
    }

    public void insert(CO2 CO2) {
        CO2DAO.insert(CO2);
    }

    public void deleteAllCO2Levels(){
        CO2DAO.deleteAllCO2Levels();
    }
}
