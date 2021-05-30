package com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints;

import com.example.smartfarmandroidapp.Domain.Humidity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HumidityAPI {
    @GET("api/farms/1/sensors/{sensorId}/measurements")
    Call<Humidity> getHumidity(@Path("sensorId") int id);
}
