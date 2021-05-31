package com.example.smartfarmandroidapp.MVVM.Viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.smartfarmandroidapp.Domain.Measurments.Measurement;
import com.example.smartfarmandroidapp.EventsBusObject.LastMeasurementsEvent;
import com.example.smartfarmandroidapp.MVVM.Repository.Monitor.IMonitorRepository;
import com.example.smartfarmandroidapp.MVVM.Repository.Monitor.MonitorRepository;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MonitorViewModel extends AndroidViewModel
{
    private IMonitorRepository monitorRepository;
    private MutableLiveData<String> CO2Level, humidity, temperature;


    public MonitorViewModel(Application application) {
        super(application);
        EventBus.getDefault().register(this);

        // Monitor values
        CO2Level = new MutableLiveData<>();
        humidity = new MutableLiveData<>();
        temperature = new MutableLiveData<>();

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

    @Subscribe
    public void onLastMeasurementsEvent(LastMeasurementsEvent lastMeasurementsEvent)
    {
        for (Measurement measurement: lastMeasurementsEvent.getLastMeasurements()){
            if(measurement.getMeasurementSensor().getType().equals("Temperature"))
            {
                temperature.postValue(measurement.getValue()+"");
            }
            else if (measurement.getMeasurementSensor().getType().equals("Humidity"))
            {
                humidity.postValue(measurement.getValue()+"");
            }
            else
            {
                CO2Level.postValue(measurement.getValue()+"");
            }
        }
        System.out.println(lastMeasurementsEvent.getLastMeasurements().size());
    }

//    @Subscribe
//    public void onCO2Event(CO2Event co2Event){
//        CO2Level.postValue(co2Event.getCO2());
//        Log.i("CO2", co2Event.getCO2());
//    }
//
//    @Subscribe
//    public void onHumidityEvent(HumidityEvent humidityEvent)
//    {
//        humidity.postValue(humidityEvent.getHumidity());
//        Log.i("HumidityEvent", humidityEvent.getHumidity());
//    }
//
//    @Subscribe
//    public void onTemperature(TemperatureEvent temperatureEvent)
//    {
//        temperature.postValue(temperatureEvent.getTemperature());
//        Log.i("Temperature", temperatureEvent.getTemperature());
//    }

    public void fetchMeasurementData(){
       monitorRepository.getLastMeasurements();
    }


}
