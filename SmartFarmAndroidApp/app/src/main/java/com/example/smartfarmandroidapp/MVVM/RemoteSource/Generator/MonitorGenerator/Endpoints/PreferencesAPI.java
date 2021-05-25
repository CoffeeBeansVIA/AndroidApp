package com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints;

import com.example.smartfarmandroidapp.domain.Farm;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PreferencesAPI {
    @GET("api/farm/{farmID}")
    Call<Farm> getPreferences(@Path("farmID") int farmID);

    @PUT("api/sensors/{sensor}/settings")
    void savePreferences(int desiredValue, int deviationValue);
}
