package com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.FarmSettingsRemouteSource;

import com.example.smartfarmandroidapp.Domain.FarmSettings.FarmSettingPreferences;
import com.example.smartfarmandroidapp.Domain.FarmSettings.SensorSettings;
import com.example.smartfarmandroidapp.EventsBusObject.PreferencesEvent;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.FarmSettingsGenerator.Endpoints.PreferencesAPI;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.FarmSettingsGenerator.ISettingsGenerator;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.FarmSettingsGenerator.SettingsGenerator;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

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
        Call<List<FarmSettingPreferences>> call = preferencesAPI.getPreferences(1);
        call.enqueue(new Callback<List<FarmSettingPreferences>>() {
            @Override
            public void onResponse(Call<List<FarmSettingPreferences>> call, Response<List<FarmSettingPreferences>> response) {
                if(response.isSuccessful()) {
                    PreferencesEvent preferencesEvent = new PreferencesEvent();
                    preferencesEvent.setPreferencesList(response.body());
                    EventBus.getDefault().post(preferencesEvent);
                }
            }

            @Override
            public void onFailure(Call<List<FarmSettingPreferences>> call, Throwable t) {

            }
        });
//        call.enqueue(new Callback<Sensors>() {
//            @Override
//            public void onResponse(Call<Sensors> call, Response<Sensors> response) {
//                if(response.isSuccessful()) {
//                    Sensors sensors = response.body();
//                    PreferencesEvent event = new PreferencesEvent();
////                    event.setPreferences(new Preferences(1,sensors.getPlantKeepers().get(0).getId(),
////                            1,//response.body().getSensors().get(0).getId(),
////                            getValue(response.body().getSensorSetting().get(0),0),
////                            getValue(response.body().getSensorSetting().get(1),1),
////                            2,//response.body().getSensors().get(1).getId(),
////                            getValue(response.body().getSensorSetting().get(1),0),
////                            getValue(response.body().getSensorSetting().get(1),1),
////                            3,//response.body().getSensors().get(2).getId(),
////                            getValue(response.body().getSensorSetting().get(2),0),
////                            getValue(response.body().getSensorSetting().get(2),1)));
////                    EventBus.getDefault().post(event);
//                }
//            }

//            @Override
//            public void onFailure(Call<Sensors> call, Throwable t) {
//
//            }
//
//            public int getValue(SensorSettings sensorSettings, int type) {
//                if(sensorSettings == null) { return 0; }
//                else if (type == 0) { return sensorSettings.getDesiredValue(); }
//                else { return sensorSettings.getDeviationValue(); }
//            }
//        });
    }


    @Override
    public void savePreferences(int sensorID, SensorSettings sensorSetting) {
        PreferencesAPI preferencesAPI = settingsGenerator.getPreferencesAPI();
        Call<ResponseBody> call = preferencesAPI.savePreferences(1, sensorID, sensorSetting);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {}

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {}
        });
    }
}
