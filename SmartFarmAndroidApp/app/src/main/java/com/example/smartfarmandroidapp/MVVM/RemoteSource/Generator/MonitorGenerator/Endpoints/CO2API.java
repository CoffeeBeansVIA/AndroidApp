package com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints;

import com.example.smartfarmandroidapp.domain.CO2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CO2API {
    @GET("api/farms/1/sensors/{sensorId}/measurements")
    Call<CO2> getCO2(@Path("sensorId") int id);
}
