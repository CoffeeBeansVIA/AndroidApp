package com.example.smartfarmandroidapp.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.smartfarmandroidapp.domain.CO2;
import com.example.smartfarmandroidapp.model.CO2DAO;
import com.example.smartfarmandroidapp.response.CO2Response;
import com.example.smartfarmandroidapp.servicegenerator.FarmServiceGenerator;
import com.example.smartfarmandroidapp.webapi.CO2API;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class CO2Repository {

    private CO2DAO CO2DAO;
    private static CO2Repository instance;
    private final MutableLiveData<CO2> currentCO2Level;

    private CO2Repository(){
        CO2DAO = CO2DAO.getInstance();
        currentCO2Level = new MutableLiveData<>();
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

    public void retrieveCO2Level(int co2Level) {
        CO2API co2API = FarmServiceGenerator.getCO2API();
        Call<CO2Response> call = co2API.getCO2(co2Level);
        call.enqueue(new Callback<CO2Response>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<CO2Response> call, Response<CO2Response> response) {
                if (response.isSuccessful()) {
                    currentCO2Level.setValue(response.body().getCO2());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<CO2Response> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
