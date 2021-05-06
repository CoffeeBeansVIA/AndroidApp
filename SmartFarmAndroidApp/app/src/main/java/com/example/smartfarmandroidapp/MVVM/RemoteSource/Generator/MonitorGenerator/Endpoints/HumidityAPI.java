package com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints;
import com.example.smartfarmandroidapp.Domain.WebApi.Humidity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HumidityAPI {
    @GET("api/sensors/{sensorId}/randomMeasurements")
    Call<Humidity> getHumidity(@Path("sensorId") int id);
}
