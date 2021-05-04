package com.example.smartfarmandroidapp.MVVM.Viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.smartfarmandroidapp.EventsBusObject.CO2Event;
import com.example.smartfarmandroidapp.EventsBusObject.HumidityEvent;
import com.example.smartfarmandroidapp.EventsBusObject.TemperatureEvent;
import com.example.smartfarmandroidapp.MVVM.Repository.Monitor.IMonitorRepository;
import com.example.smartfarmandroidapp.MVVM.Repository.Monitor.MonitorRepository;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MonitorViewModel extends AndroidViewModel
{
    private IMonitorRepository monitorRepository;
    private MutableLiveData<String> CO2Level, humidity, temperature;
    private MutableLiveData<Integer> userID, CO2Preferred, CO2Deviation, humidityPreferred, humidityDeviation, temperaturePreferred, temperatureDeviation;

    public MonitorViewModel(Application application) {
        super(application);
        EventBus.getDefault().register(this);

        // Monitor values
        CO2Level = new MutableLiveData<>();
        humidity = new MutableLiveData<>();
        temperature = new MutableLiveData<>();

        // Settings values
        userID = new MutableLiveData<>(1234);
        CO2Preferred = new MutableLiveData<>();
        CO2Deviation = new MutableLiveData<>();
        humidityPreferred = new MutableLiveData<>();
        humidityDeviation = new MutableLiveData<>();
        temperaturePreferred = new MutableLiveData<>();
        temperatureDeviation = new MutableLiveData<>();

        monitorRepository = new MonitorRepository(application);
    }

    public MutableLiveData<String> getCO2Level() {
        return CO2Level;
    }
    public MutableLiveData<String> getHumidity() {
        return humidity;
    }
    public MutableLiveData<String> getTemperature() {
        return temperature;
    }

    public MutableLiveData<Integer> getCO2Preferred() { return CO2Preferred; }
    public MutableLiveData<Integer> getCO2Deviation() { return CO2Deviation; }
    public MutableLiveData<Integer> getHumidityPreferred() { return humidityPreferred; }
    public MutableLiveData<Integer> getHumidityDeviation() { return humidityDeviation; }
    public MutableLiveData<Integer> getTemperaturePreferred() { return temperaturePreferred; }
    public MutableLiveData<Integer> getTemperatureDeviation() { return temperatureDeviation; }

    @Subscribe
    public void onCO2Event(CO2Event co2Event){
        CO2Level.postValue(co2Event.getCO2());
        Log.i("CO2", co2Event.getCO2());
    }

    @Subscribe
    public void onHumidityEvent(HumidityEvent humidityEvent)
    {
        humidity.postValue(humidityEvent.getHumidity());
        Log.i("HumidityEvent", humidityEvent.getHumidity());
    }

    @Subscribe
    public void onTemperature(TemperatureEvent temperatureEvent)
    {
        temperature.postValue(temperatureEvent.getTemperature());
        Log.i("Temperature", temperatureEvent.getTemperature());
    }

    public void fetchMeasurementData(){
        monitorRepository.getCO2();
        monitorRepository.getHumidity();
        monitorRepository.getTemperature();
    }

//    public void savePreferences(int CO2Preferred, int CO2Deviation,
//                             int humidityPreferred, int humidityDeviation,
//                             int temperaturePreferred, int temperatureDeviation) {
//        repository.savePreferences(new Preferences(userID.getValue(),
//                                CO2Preferred, CO2Deviation,
//                                humidityPreferred, humidityDeviation,
//                                temperaturePreferred, temperatureDeviation));
//    }
//
//    public LiveData<List<Preferences>> getPreferences() { return repository.getPreferences(userID.getValue()); }
}
