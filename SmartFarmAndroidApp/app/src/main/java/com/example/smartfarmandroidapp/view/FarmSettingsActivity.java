package com.example.smartfarmandroidapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartfarmandroidapp.R;

public class FarmSettingsActivity extends AppCompatActivity {
    private EditText desiredCO2, CO2Min, CO2Max;
    private EditText desiredTemperature, temperatureMin, temperatureMax;
    private EditText desiredHumidity, humidityMin, humidityMax;
    private Button saveButton, returnButton;
    private TextView info;



    private static final String FARM_SETTINGS_ACTIVITY = "FarmSettingsActivity";

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

        Log.d(FARM_SETTINGS_ACTIVITY, "onCreate was called");
    }

    @SuppressLint("SetTextI18n")
    private void onClick(View view){
        validateValues(Float.parseFloat(desiredCO2.getText().toString()),
                Float.parseFloat(CO2Min.getText().toString()),
                Float.parseFloat(CO2Max.getText().toString()),
                Float.parseFloat(desiredHumidity.getText().toString()),
                Float.parseFloat(humidityMin.getText().toString()),
                Float.parseFloat(humidityMax.getText().toString()),
                Float.parseFloat(desiredTemperature.getText().toString()),
                Float.parseFloat(temperatureMin.getText().toString()),
                Float.parseFloat(temperatureMax.getText().toString()));


        Context context = getApplicationContext();
        String text = "Update values...";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
    }

    //TODO fix this
    private void validateValues(float desiredCO2, float CO2Min, float CO2Max, float desiredHum, float humMin, float humMax, float desiredTemp, float minTemp, float maxTemp){
        if((desiredTemp > 10 && desiredTemp < 50) && (desiredHum > 5 && desiredHum < 95) && (desiredCO2 > 5 && desiredCO2 < 95)){
            Intent intent = new Intent(FarmSettingsActivity.this, MonitorActivity.class);
            startActivity(intent);
        } else {
            info.setText("Something went wrong");
        }
    }

    private float getNumber(TextView textView) { return Float.parseFloat(textView.getText().toString()); }
}