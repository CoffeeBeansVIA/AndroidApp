package com.example.smartfarmandroidapp.Enums;

public enum SensorEnum {

    TEMPERATURE(1),
    HUMIDITY(2),
    C02(3);

    private int mValue;

    SensorEnum(int number) {
        mValue = number;
    }

    public int getmValue() {
        return mValue;
    }
}
