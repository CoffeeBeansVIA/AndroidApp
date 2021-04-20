package com.example.smartfarmandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smartfarmandroidapp.viewmodel.CO2ViewModel;
import com.example.smartfarmandroidapp.viewmodel.HumidityViewModel;
import com.example.smartfarmandroidapp.viewmodel.MovementViewModel;
import com.example.smartfarmandroidapp.viewmodel.TemperatureViewModel;

public class ValueTweekingActivity extends AppCompatActivity {
    private EditText co2Min, co2Max;
    private EditText temperatureMin, temperatureMax;
    private EditText humidityMin, humidityMax;
    private Button saveButton, returnButton;

    private TemperatureViewModel temperatureViewModel;
    private HumidityViewModel humidityViewModel;
    private CO2ViewModel co2ViewModel;
    private MovementViewModel movementViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_tweeking);

        co2Min = findViewById(R.id.co2Min);
        co2Max = findViewById(R.id.co2Max);
        temperatureMin = findViewById(R.id.temperatureMin);
        temperatureMax  = findViewById(R.id.temperatureMax);
        humidityMin = findViewById(R.id.humidityMin);
        humidityMax = findViewById(R.id.humidityMax);

        saveButton = findViewById(R.id.saveThresholdButton);
        returnButton = findViewById(R.id.returnFromTewakingButton);

        saveButton.setOnClickListener(v -> {

        });

        returnButton.setOnClickListener(v -> { finish(); });
    }


    private int getNumber(TextView textView) { return Integer.parseInt(textView.getText().toString()); }
}