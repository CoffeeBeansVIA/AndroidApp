package com.example.smartfarmandroidapp.Domain.FarmSettings;

public class SensorSettings {
   private int desiredValue;
    private int deviationValue;


    public int getPreferredValue() {
        return desiredValue;
    }


    public int getDeviationValue() {
        return deviationValue;
    }

}
