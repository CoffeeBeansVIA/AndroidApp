package com.example.smartfarmandroidapp.Domain.FarmSettings;

public class SensorSettings {
    private int sensorId;
    private int desiredValue;
    private int deviationValue;

    public SensorSettings(int desiredValue, int deviationValue, int sensorId) {
        this.desiredValue = desiredValue;
        this.deviationValue = deviationValue;
        this.sensorId = sensorId;
    }

    public int getPreferredValue() {
        return desiredValue;
    }


    public int getDeviationValue() {
        return deviationValue;
    }

    public int getSensorId() {
        return sensorId;
    }

    public int getDesiredValue() {
        return desiredValue;
    }
}
