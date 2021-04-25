package com.example.smartfarmandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartfarmandroidapp.viewmodel.CO2ViewModel;
import com.example.smartfarmandroidapp.viewmodel.HumidityViewModel;
import com.example.smartfarmandroidapp.viewmodel.TemperatureViewModel;

public class FarmSettingsActivity extends AppCompatActivity {
    EditText desiredCO2, CO2Min, CO2Max;
    EditText desiredTemperature, temperatureMin, temperatureMax;
    EditText desiredHumidity, humidityMin, humidityMax;
    Button saveButton, returnButton;
    TextView info;

    CO2ViewModel CO2ViewModel;
    TemperatureViewModel temperatureViewModel;
    HumidityViewModel humidityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_settings);

        desiredCO2 = findViewById(R.id.desiredCO2);
        CO2Min = findViewById(R.id.co2Min);
        CO2Max = findViewById(R.id.co2Max);
        desiredTemperature = findViewById(R.id.desiredTemperature);
        temperatureMin = findViewById(R.id.minTemperature);
        temperatureMax  = findViewById(R.id.maxTemperature);
        desiredHumidity = findViewById(R.id.desiredHumidity);
        humidityMin = findViewById(R.id.minHumidity);
        humidityMax = findViewById(R.id.maxHumidity);

        saveButton = findViewById(R.id.saveThresholdButton);
        returnButton = findViewById(R.id.returnFromTweakingButton);

        info = findViewById(R.id.errorTextView);

        saveButton.setOnClickListener(view -> onClick(info));

        returnButton.setOnClickListener(v -> { finish(); });
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view){
        validateValues(Float.parseFloat(desiredCO2.getText().toString()),
                Float.parseFloat(CO2Min.getText().toString()),
                Float.parseFloat(CO2Max.getText().toString()),
                Float.parseFloat(desiredHumidity.getText().toString()),
                Float.parseFloat(humidityMin.getText().toString()),
                Float.parseFloat(humidityMax.getText().toString()),
                Float.parseFloat(desiredTemperature.getText().toString()),
                Float.parseFloat(temperatureMin.getText().toString()),
                Float.parseFloat(temperatureMax.getText().toString()));

        CO2ViewModel.updateThresholds(getNumber(desiredCO2), getNumber(CO2Min), getNumber(CO2Max));
        temperatureViewModel.updateThresholds(getNumber(desiredTemperature), getNumber(temperatureMin), getNumber(temperatureMax));
        humidityViewModel.updateThresholds(getNumber(desiredHumidity), getNumber(humidityMin), getNumber(humidityMax));

        Context context = getApplicationContext();
        String text = "Update values...";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
    }

    private void validateValues(float desiredCO2, float CO2Min, float CO2Max, float desiredHum, float humMin, float humMax, float desiredTemp, float minTemp, float maxTemp){
        if((desiredTemp > 10 && desiredTemp < 50) || (desiredHum > 5 && desiredHum < 95) || (desiredCO2 > 5 && desiredCO2 < 95)){
            Intent intent = new Intent(FarmSettingsActivity.this, MonitorActivity.class);
            startActivity(intent);
        } else {
            info.setText("Something went wrong");
        }
    }

    private float getNumber(TextView textView) { return Float.parseFloat(textView.getText().toString()); }
}