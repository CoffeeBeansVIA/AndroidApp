package com.example.smartfarmandroidapp.webapi;

import com.example.smartfarmandroidapp.response.TemperatureResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TemperatureAPI {
    @GET("api/sensors/1/randomMeasurements")
    Call<TemperatureResponse> getTemperature(@Path("value") int value);
}
