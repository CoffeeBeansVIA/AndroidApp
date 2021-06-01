package com.example.smartfarmandroidapp.MVVM.Repository.FarmSettings;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.smartfarmandroidapp.Domain.Farm.Farm;
import com.example.smartfarmandroidapp.Domain.FarmSettings.FarmSettingPreferences;
import com.example.smartfarmandroidapp.Domain.FarmSettings.SensorSettings;
import com.example.smartfarmandroidapp.Domain.Preferences.Preferences_ROOM;
import com.example.smartfarmandroidapp.Enums.SensorEnum;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.FarmSettingsRemouteSource.ISettingsRemoteData;
import com.example.smartfarmandroidapp.MVVM.RemoteSource.RemouteSource.FarmSettingsRemouteSource.SettingsRemoteData;
import com.example.smartfarmandroidapp.EventsBusObject.PreferencesEvent;
import com.example.smartfarmandroidapp.MVVM.RoomModel.Models.Preferences.IPreferencesModel;
import com.example.smartfarmandroidapp.MVVM.RoomModel.Models.Preferences.PreferencesModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class SettingsRepository implements ISettingsRepository {
    private IPreferencesModel model;
    private ISettingsRemoteData remoteData;
    private int userID, CO2Preferred, CO2Deviation,
            humidityPreferred, humidityDeviation,
            temperaturePreferred, temperatureDeviation;

    public SettingsRepository(Application application) {
        EventBus.getDefault().register(this);
        model = new PreferencesModel(application);
        remoteData = new SettingsRemoteData();
    }

    @Override
    public void savePreferences(Preferences_ROOM preferences) {
        List<SensorSettings> sensorSettingsList = new ArrayList<>();
        sensorSettingsList.add(new SensorSettings(preferences.getDesiredCO2(), preferences.getDeviationCO2(), SensorEnum.C02.getmValue()));
        sensorSettingsList.add(new SensorSettings(preferences.getDesiredTemperature(), preferences.getDeviationTemperature(), SensorEnum.TEMPERATURE.getmValue()));
        sensorSettingsList.add(new SensorSettings(preferences.getDesiredHumidity(), preferences.getDeviationHumidity(), SensorEnum.HUMIDITY.getmValue()));
        remoteData.savePreferences(sensorSettingsList);
    }

    @Subscribe // This is the last part I need to finish
    public void onPreferencesEvent(PreferencesEvent preferencesEvent) {
        for (FarmSettingPreferences farmSettingPreference : preferencesEvent.getPreferencesArrayList()) {
            if (farmSettingPreference.getType().equals("Temperature")) {
                temperaturePreferred = farmSettingPreference.getSensorSetting().getPreferredValue();
                temperatureDeviation = farmSettingPreference.getSensorSetting().getDeviationValue();

            } else if (farmSettingPreference.getType().equals("Humidity")) {
                humidityPreferred = farmSettingPreference.getSensorSetting().getPreferredValue();
                humidityDeviation = farmSettingPreference.getSensorSetting().getDeviationValue();
            } else {
                CO2Preferred = farmSettingPreference.getSensorSetting().getPreferredValue();
                CO2Deviation = farmSettingPreference.getSensorSetting().getDeviationValue();
            }
        }

        model.savePreferences(new Preferences_ROOM(userID, SensorEnum.C02.getmValue(), CO2Preferred, CO2Deviation,
                SensorEnum.TEMPERATURE.getmValue(), humidityPreferred, humidityDeviation,
                SensorEnum.TEMPERATURE.getmValue(), temperaturePreferred, temperatureDeviation));
        model.getPreferences(SensorEnum.C02.getmValue());
        Log.i("Preferences", "Preferences updated");
    }

    @Override
    public void getPreferences(int userID) { model.getPreferences(userID); }
}
