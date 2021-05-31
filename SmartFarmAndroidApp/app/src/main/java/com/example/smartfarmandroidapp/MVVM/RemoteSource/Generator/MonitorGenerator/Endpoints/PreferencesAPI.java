package com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints;

import com.example.smartfarmandroidapp.Domain.FarmSettings.SensorSettings;
import com.example.smartfarmandroidapp.Domain.FarmSettings.FarmSettingPreferences;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PreferencesAPI {
    @GET("api/farms/{farmId}/sensors")
    Call<List<FarmSettingPreferences>> getPreferences(@Path("farmId") int farmID);

    @PUT("api/farms/{farmId}/sensors/{sensorId}/settings")
    Call<ResponseBody> savePreferences(@Path("farmId") int farmId, @Path("sensorId") int sensorId, @Body SensorSettings sensorSetting);
}
