package com.example.smartfarmandroidapp.repository;

import com.example.smartfarmandroidapp.Events.CO2Event;
import com.example.smartfarmandroidapp.Events.HumidityEvent;
import com.example.smartfarmandroidapp.Events.TemperatureEvent;
import com.example.smartfarmandroidapp.domain.CO2;
import com.example.smartfarmandroidapp.domain.Humidity;
import com.example.smartfarmandroidapp.domain.Temperature;
import com.example.smartfarmandroidapp.servicegenerator.FarmServiceGenerator;
import com.example.smartfarmandroidapp.webapi.CO2API;
import com.example.smartfarmandroidapp.webapi.HumidityAPI;
import com.example.smartfarmandroidapp.webapi.TemperatureAPI;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class Repository {
    public void getCO2() {
        CO2API co2API = FarmServiceGenerator.getCO2API();
        Call<CO2> call = co2API.getCO2(3);
        call.enqueue(new Callback<CO2>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<CO2> call, Response<CO2> response) {
                if (response.isSuccessful()) {
                    CO2Event event = new CO2Event();
                    event.setCO2(response.body().getValue()+"");
                    EventBus.getDefault().post(event);
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<CO2> call, Throwable t) {
                t.printStackTrace();
            }

        });
    }

    public void getHumidity(){
        HumidityAPI humidityAPI = FarmServiceGenerator.getHumidityAPI();
        Call<Humidity> call = humidityAPI.getHumidity(2);
        call.enqueue(new Callback<Humidity>() {
            @Override
            public void onResponse(Call<Humidity> call, Response<Humidity> response) {
                if(response.isSuccessful())
                {
                    HumidityEvent event = new HumidityEvent();
                    event.setHumidity(response.body().getValue()+"");
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<Humidity> call, Throwable t) {

            }
        });
    }

    public void getTemperature(){
        TemperatureAPI temperatureAPI = FarmServiceGenerator.getTemperatureAPI();
        Call<Temperature> call = temperatureAPI.getTemperature(1);
        call.enqueue(new Callback<Temperature>() {
            @Override
            public void onResponse(Call<Temperature> call, Response<Temperature> response) {
                if(response.isSuccessful())
                {
                    TemperatureEvent event = new TemperatureEvent();
                    event.setTemperature(response.body().getValue()+"");
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<Temperature> call, Throwable t) {

            }
        });
    }
}
