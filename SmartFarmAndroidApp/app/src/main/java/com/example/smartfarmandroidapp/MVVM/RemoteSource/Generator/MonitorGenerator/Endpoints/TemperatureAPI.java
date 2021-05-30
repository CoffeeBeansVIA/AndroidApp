package com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints;

import com.example.smartfarmandroidapp.Domain.Temperature;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TemperatureAPI {
    @GET("api/farms/1/sensors/{sensorId}/measurements")
    Call<Temperature> getTemperature(@Path("sensorId") int id);
}
