package com.example.smartfarmandroidapp.webapi;
import com.example.smartfarmandroidapp.domain.Humidity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HumidityAPI {
    @GET("api/sensors/{sensorId}/randomMeasurements")
    Call<Humidity> getHumidity(@Path("sensorId") int id);
}
