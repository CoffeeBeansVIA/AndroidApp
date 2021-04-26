package com.example.smartfarmandroidapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.smartfarmandroidapp.model.MonitorModel;

public class MonitorViewModel extends ViewModel
{
    private MonitorModel monitorModel;
    private MutableLiveData<String> CO2Level, humidity, temperature;
    public MonitorViewModel() {
          CO2Level = new MutableLiveData<>();
          humidity = new MutableLiveData<>();
          temperature = new MutableLiveData<>();
          monitorModel = new MonitorModel();
    }

  public void fetchMeasurementData(){
     monitorModel.getCO2();
     monitorModel.getHumidity();
     monitorModel.getTemperature();
  }



}
