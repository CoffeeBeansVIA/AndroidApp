package com.example.smartfarmandroidapp.model;

import android.util.Log;

import com.example.smartfarmandroidapp.domain.CO2;
import com.example.smartfarmandroidapp.servicegenerator.FarmServiceGenerator;
import com.example.smartfarmandroidapp.webapi.CO2API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MonitorModel {
    private String str = "";
    public MonitorModel() {
    }

    public void getCO2() {
        CO2API co2API = FarmServiceGenerator.getCO2API();
        Call<CO2> call = co2API.getCO2(3);
        call.enqueue(new Callback<CO2>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<CO2> call, Response<CO2> response) {
                if (response.isSuccessful()) {
                    Log.i("Tag", "LocalMessage");
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<CO2> call, Throwable t) {
                t.printStackTrace();
            }

        });

    }
}
