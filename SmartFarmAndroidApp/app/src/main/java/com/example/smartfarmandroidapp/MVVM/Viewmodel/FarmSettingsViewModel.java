package com.example.smartfarmandroidapp.MVVM.Viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.smartfarmandroidapp.EventsBusObject.PreferencesEvent;
import com.example.smartfarmandroidapp.MVVM.Repository.Monitor.ISettingsRepository;
import com.example.smartfarmandroidapp.MVVM.Repository.Monitor.SettingsRepository;
import com.example.smartfarmandroidapp.domain.Preferences;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class FarmSettingsViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> userID, CO2Preferred, CO2Deviation, humidityPreferred, humidityDeviation, temperaturePreferred, temperatureDeviation;
    private ISettingsRepository repository;

    public FarmSettingsViewModel(@NonNull Application application) {
        super(application);
        EventBus.getDefault().register(this);

        userID = new MutableLiveData<>();
        CO2Preferred = new MutableLiveData<>();
        CO2Deviation = new MutableLiveData<>();
        humidityPreferred = new MutableLiveData<>();
        humidityDeviation = new MutableLiveData<>();
        temperaturePreferred = new MutableLiveData<>();
        temperatureDeviation = new MutableLiveData<>();

        userID.setValue(1);

        repository = new SettingsRepository(application);
    }

    public MutableLiveData<Integer> getCO2Preferred() { return CO2Preferred; }
    public MutableLiveData<Integer> getCO2Deviation() { return CO2Deviation; }
    public MutableLiveData<Integer> getHumidityPreferred() { return humidityPreferred; }
    public MutableLiveData<Integer> getHumidityDeviation() { return humidityDeviation; }
    public MutableLiveData<Integer> getTemperaturePreferred() { return temperaturePreferred; }
    public MutableLiveData<Integer> getTemperatureDeviation() { return temperatureDeviation; }

    public void savePreferences(int CO2Preferred, int CO2Deviation,
                                int temperaturePreferred, int temperatureDeviation,
                                int humidityPreferred, int humidityDeviation) {
        repository.savePreferences(new Preferences(userID.getValue(),
                                CO2Preferred, CO2Deviation,
                                temperaturePreferred, temperatureDeviation,
                                humidityPreferred, humidityDeviation));
    }

    @Subscribe
    public void onPreferencesEvent(PreferencesEvent preferencesEvent){
        CO2Preferred.postValue(preferencesEvent.getPreferences().getDesiredCO2());
        CO2Deviation.postValue(preferencesEvent.getPreferences().getDeviationCO2());
        humidityPreferred.postValue(preferencesEvent.getPreferences().getDesiredHumidity());
        humidityDeviation.postValue(preferencesEvent.getPreferences().getDeviationHumidity());
        temperaturePreferred.postValue(preferencesEvent.getPreferences().getDesiredTemperature());
        temperatureDeviation.postValue(preferencesEvent.getPreferences().getDesiredTemperature());
        Log.i("Preferences", "Preferences updated");
    }

    public void getPreferences() { repository.getPreferences(userID.getValue()); }
}
