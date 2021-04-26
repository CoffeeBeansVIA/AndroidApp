package com.example.smartfarmandroidapp.webapi;

import com.example.smartfarmandroidapp.domain.CO2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CO2API {
    @GET("api/sensors/{sensorId}/randomMeasurements")
    Call<CO2> getCO2(@Path("sensorId") int id);
}
