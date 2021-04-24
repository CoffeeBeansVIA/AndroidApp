package com.example.smartfarmandroidapp.webapi;

import com.example.smartfarmandroidapp.response.HumidityResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HumidityAPI {
    @GET("api/sensors/2/randomMeasurements")
    Call<HumidityResponse> getHumidity(@Path("value") int value);
}
