package com.example.smartfarmandroidapp.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.smartfarmandroidapp.domain.Humidity;
import com.example.smartfarmandroidapp.model.HumidityDAO;
import com.example.smartfarmandroidapp.response.HumidityResponse;
import com.example.smartfarmandroidapp.servicegenerator.FarmServiceGenerator;
import com.example.smartfarmandroidapp.webapi.HumidityAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class HumidityRepository {
    private HumidityDAO humidityDAO;
    private static HumidityRepository instance;
    private final MutableLiveData<Humidity> currentHumidity;

    private HumidityRepository(){
        humidityDAO = HumidityDAO.getInstance();
        currentHumidity = new MutableLiveData<>();
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

    public void retrieveHumidity(int humidity) {
        HumidityAPI humidityAPI = FarmServiceGenerator.getHumidityAPI();
        Call<HumidityResponse> call = humidityAPI.getHumidity(humidity);
        call.enqueue(new Callback<HumidityResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<HumidityResponse> call, Response<HumidityResponse> response) {
                if (response.isSuccessful()) {
                    currentHumidity.setValue(response.body().getHumidity());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<HumidityResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
