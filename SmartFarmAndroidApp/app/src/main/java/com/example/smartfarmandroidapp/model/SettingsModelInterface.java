package com.example.smartfarmandroidapp.model;

import androidx.lifecycle.MutableLiveData;

public interface SettingsModelInterface {
    static MutableLiveData<Integer> getCO2Preferred() { return null; }
    static MutableLiveData<Integer> getCO2Deviation() { return null; }
    static MutableLiveData<Integer> getHumidityPreferred() { return null; }
    static MutableLiveData<Integer> getHumidityDeviation() { return null; }
    static MutableLiveData<Integer> getTemperaturePreferred() { return null; }
    static MutableLiveData<Integer> getTemperatureDeviation() { return null; }
}
