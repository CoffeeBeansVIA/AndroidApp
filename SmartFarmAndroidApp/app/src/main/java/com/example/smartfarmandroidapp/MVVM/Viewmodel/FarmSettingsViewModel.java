package com.example.smartfarmandroidapp.MVVM.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.smartfarmandroidapp.Domain.Preferences;
import com.example.smartfarmandroidapp.MVVM.Repository.Monitor.ISettingsRepository;

import java.util.List;

public class FarmSettingsViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> userID, CO2Preferred, CO2Deviation, humidityPreferred, humidityDeviation, temperaturePreferred, temperatureDeviation;
    private ISettingsRepository repository;

    public FarmSettingsViewModel(@NonNull Application application) {
        super(application);

        userID = new MutableLiveData<>(1234);
        CO2Preferred = new MutableLiveData<>();
        CO2Deviation = new MutableLiveData<>();
        humidityPreferred = new MutableLiveData<>();
        humidityDeviation = new MutableLiveData<>();
        temperaturePreferred = new MutableLiveData<>();
        temperatureDeviation = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getCO2Preferred() { return CO2Preferred; }
    public MutableLiveData<Integer> getCO2Deviation() { return CO2Deviation; }
    public MutableLiveData<Integer> getHumidityPreferred() { return humidityPreferred; }
    public MutableLiveData<Integer> getHumidityDeviation() { return humidityDeviation; }
    public MutableLiveData<Integer> getTemperaturePreferred() { return temperaturePreferred; }
    public MutableLiveData<Integer> getTemperatureDeviation() { return temperatureDeviation; }

    public void savePreferences(int CO2Preferred, int CO2Deviation,
                             int humidityPreferred, int humidityDeviation,
                             int temperaturePreferred, int temperatureDeviation) {
        repository.savePreferences(new Preferences(userID.getValue(),
                                CO2Preferred, CO2Deviation,
                                humidityPreferred, humidityDeviation,
                                temperaturePreferred, temperatureDeviation));
    }

    public LiveData<List<Preferences>> getPreferences() { return repository.getPreferences(userID.getValue()); }
}
