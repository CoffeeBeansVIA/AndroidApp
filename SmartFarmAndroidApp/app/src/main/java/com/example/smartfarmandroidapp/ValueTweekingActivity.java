package com.example.smartfarmandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smartfarmandroidapp.viewmodel.CO2ViewModel;
import com.example.smartfarmandroidapp.viewmodel.HumidityViewModel;
import com.example.smartfarmandroidapp.viewmodel.TemperatureViewModel;

public class ValueTweekingActivity extends AppCompatActivity {
    private EditText CO2Min, CO2Max;
    private EditText temperatureMin, temperatureMax;
    private EditText humidityMin, humidityMax;
    private Button saveButton, returnButton;

    private CO2ViewModel CO2ViewModel;
    private TemperatureViewModel temperatureViewModel;
    private HumidityViewModel humidityViewModel;
    private MovementViewModel movementViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_tweeking);

        CO2Min = findViewById(R.id.co2Min);
        CO2Max = findViewById(R.id.co2Max);
        temperatureMin = findViewById(R.id.temperatureMin);
        temperatureMax  = findViewById(R.id.temperatureMax);
        humidityMin = findViewById(R.id.humidityMin);
        humidityMax = findViewById(R.id.humidityMax);

        saveButton = findViewById(R.id.saveThresholdButton);
        returnButton = findViewById(R.id.returnFromTewakingButton);

        saveButton.setOnClickListener(v -> {
            CO2ViewModel.updateThresholds(getNumber(CO2Min), getNumber(CO2Max));
            temperatureViewModel.updateThresholds(getNumber(temperatureMin), getNumber(temperatureMax));
            humidityViewModel.updateThresholds(getNumber(humidityMin), getNumber(humidityMax));
        });

        returnButton.setOnClickListener(v -> { finish(); });
    }


    private int getNumber(TextView textView) { return Integer.parseInt(textView.getText().toString()); }
}