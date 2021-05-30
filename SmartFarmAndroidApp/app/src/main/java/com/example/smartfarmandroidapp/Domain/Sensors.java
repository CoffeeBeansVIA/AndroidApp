package com.example.smartfarmandroidapp.Domain;

import java.util.ArrayList;

public class Sensors {
    private ArrayList<SensorSettings> sensorSetting;

    public ArrayList<SensorSettings> getSensorSetting() {
        return sensorSetting;
    }

    public static class SensorSettings {
        int desiredValue;
        int deviationValue;

        public SensorSettings(int desiredValue, int deviationValue) {
            this.desiredValue = desiredValue;
            this.deviationValue = deviationValue;
        }

        public int getDesiredValue() {
            return desiredValue;
        }

        public void setDesiredValue(int desiredValue) {
            this.desiredValue = desiredValue;
        }

        public int getDeviationValue() {
            return deviationValue;
        }

        public void setDeviationValue(int deviationValue) {
            this.deviationValue = deviationValue;
        }
    }
}
