package com.example.smartfarmandroidapp.webapi;

import com.example.smartfarmandroidapp.domain.CO2;
import com.example.smartfarmandroidapp.domain.Humidity;
import com.example.smartfarmandroidapp.domain.Temperature;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ValueAPI {
    @GET("api/sensors/{sensorId}/randomMeasurements")
    Call<CO2> getCO2(@Path("sensorId") int id);




}
