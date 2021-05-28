package com.example.smartfarmandroidapp.MVVM.RemoteSource.Generator.MonitorGenerator.Endpoints;

import com.example.smartfarmandroidapp.domain.Farm;

public class InformationToBeSaved {
    int sensorId;
    Farm.SensorSettings sensorSetting;

    public InformationToBeSaved(int sensorId, Farm.SensorSettings sensorSetting) {
        this.sensorId = sensorId;
        this.sensorSetting = sensorSetting;
    }
}
