package com.example.smartfarmandroidapp.webapi;

import com.example.smartfarmandroidapp.response.CO2Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CO2API {
    @GET("api/sensors/3/randomMeasurements")
    Call<CO2Response> getCO2(@Path("value") int value);
}
