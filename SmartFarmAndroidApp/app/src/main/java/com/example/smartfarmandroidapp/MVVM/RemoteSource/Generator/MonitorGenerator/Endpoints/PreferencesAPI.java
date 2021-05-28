package com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints;

import com.example.smartfarmandroidapp.domain.Farm;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PreferencesAPI {
    @GET("api/farms/{farmID}")
    Call<Farm> getPreferences(@Path("farmID") int farmID);

    @PUT("api/sensors/{sensorID}/settings")
    Call<ResponseBody> savePreferences(@Body InformationToBeSaved information);
}
