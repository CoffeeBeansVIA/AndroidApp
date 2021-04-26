package com.example.smartfarmandroidapp.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.smartfarmandroidapp.domain.Temperature;
import com.example.smartfarmandroidapp.response.TemperatureResponse;
import com.example.smartfarmandroidapp.servicegenerator.FarmServiceGenerator;
import com.example.smartfarmandroidapp.webapi.TemperatureAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class TemperatureRepository {

    private TemperatureDAO temperatureDAO;
    private static TemperatureRepository instance;
    private final MutableLiveData<Temperature> currentTemperature;

    private TemperatureRepository(){
        temperatureDAO = TemperatureDAO.getInstance();
        currentTemperature = new MutableLiveData<>();
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

    public void retrieveTemperature(int temperature) {
        TemperatureAPI temperatureAPI = FarmServiceGenerator.getTemperatureAPI();
        Call<TemperatureResponse> call = temperatureAPI.getTemperature(temperature);
        call.enqueue(new Callback<TemperatureResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<TemperatureResponse> call, Response<TemperatureResponse> response) {
                if (response.isSuccessful()) {
                    currentTemperature.setValue(response.body().getTemperature());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<TemperatureResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
