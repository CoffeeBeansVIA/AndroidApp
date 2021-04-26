package com.example.smartfarmandroidapp.webapi;
import com.example.smartfarmandroidapp.domain.Humidity;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HumidityAPI {
    @GET("api/sensors/2/randomMeasurements")
    Call<Humidity> getHumidity();
}
