package com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.MonitorRemouteSource;

import com.example.smartfarmandroidapp.EventsBusObject.PreferencesEvent;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints.PreferencesAPI;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.ISettingsGenerator;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.SettingsGenerator;
import com.example.smartfarmandroidapp.domain.Farm;
import com.example.smartfarmandroidapp.domain.Preferences;

import org.greenrobot.eventbus.EventBus;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingsRemoteData implements ISettingsRemoteData{
    private ISettingsGenerator settingsGenerator;

    public SettingsRemoteData() {
        settingsGenerator = new SettingsGenerator();
    }

    @Override
    public void getPreferences(int userID) {
        PreferencesAPI preferencesAPI = settingsGenerator.getPreferencesAPI();
        Call<Farm> call = preferencesAPI.getPreferences(1);
        call.enqueue(new Callback<Farm>() {
            @Override
            public void onResponse(Call<Farm> call, Response<Farm> response) {
                if(response.isSuccessful()) {
                    Farm responseFarm = response.body();
                    PreferencesEvent event = new PreferencesEvent();
                    event.setPreferences(new Preferences(responseFarm.getPlantKeepers().get(0).getId(),
                            response.body().getSensors().get(0).getId(),
                            getValue(response.body().getSensors().get(0).getSensorSettings(),0),
                            getValue(response.body().getSensors().get(0).getSensorSettings(),1),
                            response.body().getSensors().get(1).getId(),
                            getValue(response.body().getSensors().get(1).getSensorSettings(),0),
                            getValue(response.body().getSensors().get(1).getSensorSettings(),1),
                            response.body().getSensors().get(2).getId(),
                            getValue(response.body().getSensors().get(2).getSensorSettings(),0),
                            getValue(response.body().getSensors().get(2).getSensorSettings(),1)));
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<Farm> call, Throwable t) {

            }

            public int getValue(Farm.SensorSettings sensorSettings, int type) {
                if(sensorSettings == null) { return 0; }
                else if (type == 0) { return sensorSettings.getDesiredValue(); }
                else { return sensorSettings.getDeviationValue(); }
            }
        });
    }

    @Override
    public void savePreferences(int sensorID, Farm.SensorSettings sensorSetting) {
        PreferencesAPI preferencesAPI = settingsGenerator.getPreferencesAPI();
        Call<ResponseBody> call = preferencesAPI.savePreferences(sensorID, sensorSetting);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
