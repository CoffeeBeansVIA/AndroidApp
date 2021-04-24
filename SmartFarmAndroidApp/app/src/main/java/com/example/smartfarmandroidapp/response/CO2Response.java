package com.example.smartfarmandroidapp.response;

import com.example.smartfarmandroidapp.domain.CO2;

public class CO2Response {
    private int co2Value;

    public CO2 getCO2() {
        return new CO2(co2Value);
    }
}
