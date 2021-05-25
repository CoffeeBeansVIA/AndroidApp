package com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.MonitorRemouteSource;

import com.example.smartfarmandroidapp.EventsBusObject.PreferencesEvent;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints.PreferencesAPI;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.ISettingsGenerator;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.SettingsGenerator;
import com.example.smartfarmandroidapp.domain.Farm;
import com.example.smartfarmandroidapp.domain.Preferences;

import org.greenrobot.eventbus.EventBus;

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
                    event.setPreferences(new Preferences(responseFarm.getPlantKeepers().get(1).getId(),
                            responseFarm.getSensors().get(1).getSensorSettings().get(1),
                            responseFarm.getSensors().get(1).getSensorSettings().get(2),
                            responseFarm.getSensors().get(2).getSensorSettings().get(1),
                            responseFarm.getSensors().get(2).getSensorSettings().get(2),
                            responseFarm.getSensors().get(3).getSensorSettings().get(1),
                            responseFarm.getSensors().get(3).getSensorSettings().get(2)));
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<Farm> call, Throwable t) {

            }
        });
    }
}
