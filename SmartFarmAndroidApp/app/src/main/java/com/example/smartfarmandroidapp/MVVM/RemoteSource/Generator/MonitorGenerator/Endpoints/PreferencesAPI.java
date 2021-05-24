package com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints;

import com.example.smartfarmandroidapp.domain.Farm;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface PreferencesAPI {
    @GET("farm/{farmID}")
    Call<Farm> getPreferences(int farmID);

    @PUT()
    void savePreferences(Farm farm);
}
