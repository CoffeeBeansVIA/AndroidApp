package com.example.smartfarmandroidapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.smartfarmandroidapp.Events.CO2Event;
import com.example.smartfarmandroidapp.Events.HumidityEvent;
import com.example.smartfarmandroidapp.Events.TemperatureEvent;
import com.example.smartfarmandroidapp.model.MonitorModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MonitorViewModel extends ViewModel
{
    private MonitorModel monitorModel;
    private MutableLiveData<String> CO2Level, humidity, temperature;
    private MutableLiveData<Integer> CO2Preferred, CO2Deviation, humidityPreferred, humidityDeviation, temperaturePreferred, temperatureDeviation;

    public MonitorViewModel() {
        EventBus.getDefault().register(this);
          CO2Level = new MutableLiveData<>();
          humidity = new MutableLiveData<>();
          temperature = new MutableLiveData<>();
          monitorModel = new MonitorModel();
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
     monitorModel.getCO2();
     monitorModel.getHumidity();
     monitorModel.getTemperature();
  }
}
