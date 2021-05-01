package com.example.smartfarmandroidapp.webapi;

import com.example.smartfarmandroidapp.domain.Temperature;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TemperatureAPI {
    @GET("api/sensors/{sensorId}/randomMeasurements")
    Call<Temperature> getTemperature(@Path("sensorId") int id);
}
