package com.example.smartfarmandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smartfarmandroidapp.viewmodel.CO2ViewModel;
import com.example.smartfarmandroidapp.viewmodel.HumidityViewModel;
import com.example.smartfarmandroidapp.viewmodel.TemperatureViewModel;

public class FarmSettingsActivity extends AppCompatActivity {
    private EditText desiredCO2, CO2Min, CO2Max;
    private EditText desiredTemperature, temperatureMin, temperatureMax;
    private EditText desiredHumidity, humidityMin, humidityMax;
    private Button saveButton, returnButton;

    private CO2ViewModel CO2ViewModel;
    private TemperatureViewModel temperatureViewModel;
    private HumidityViewModel humidityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_settings);

        desiredCO2 = findViewById(R.id.desiredCO2);
        CO2Min = findViewById(R.id.co2Min);
        CO2Max = findViewById(R.id.co2Max);
        desiredTemperature = findViewById(R.id.desiredTemperature);
        temperatureMin = findViewById(R.id.temperatureMin);
        temperatureMax  = findViewById(R.id.temperatureMax);
        desiredHumidity = findViewById(R.id.desiredHumidity);
        humidityMin = findViewById(R.id.humidityMin);
        humidityMax = findViewById(R.id.humidityMax);

        saveButton = findViewById(R.id.saveThresholdButton);
        returnButton = findViewById(R.id.returnFromTweakingButton);

        saveButton.setOnClickListener(v -> {
            CO2ViewModel.updateThresholds(getNumber(desiredCO2), getNumber(CO2Min), getNumber(CO2Max));
            temperatureViewModel.updateThresholds(getNumber(desiredTemperature), getNumber(temperatureMin), getNumber(temperatureMax));
            humidityViewModel.updateThresholds(getNumber(desiredHumidity), getNumber(humidityMin), getNumber(humidityMax));
        });

        returnButton.setOnClickListener(v -> { finish(); });
    }


    private float getNumber(TextView textView) { return Float.parseFloat(textView.getText().toString()); }
}