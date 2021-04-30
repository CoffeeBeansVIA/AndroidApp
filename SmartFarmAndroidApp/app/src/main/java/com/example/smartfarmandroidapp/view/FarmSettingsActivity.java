package com.example.smartfarmandroidapp.view;

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

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartfarmandroidapp.R;

public class FarmSettingsActivity extends AppCompatActivity {
    private EditText desiredCO2, CO2Max;
    private EditText desiredTemperature, temperatureMax;
    private EditText desiredHumidity, humidityMax;
    private Button saveButton, returnButton;
    private TextView info;



    private static final String FARM_SETTINGS_ACTIVITY = "FarmSettingsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_settings);

        desiredCO2 = findViewById(R.id.desiredCO2);
        CO2Max = findViewById(R.id.maxCO2Dev);
        desiredTemperature = findViewById(R.id.desiredTemperature);
        temperatureMax  = findViewById(R.id.maxTemperatureDev);
        desiredHumidity = findViewById(R.id.desiredHumidity);
        humidityMax = findViewById(R.id.maxHumidityDev);

        saveButton = findViewById(R.id.saveThresholdButton);
        returnButton = findViewById(R.id.returnFromTweakingButton);

        info = findViewById(R.id.errorTextView);

        saveButton.setOnClickListener(view -> onClickSave(info));

        returnButton.setOnClickListener(v -> { finish(); });

        Log.d(FARM_SETTINGS_ACTIVITY, "onCreate was called");
    }

    @SuppressLint("SetTextI18n")
    private void onClickSave(View view){
        validateValues(Float.parseFloat(desiredCO2.getText().toString()),
                Float.parseFloat(CO2Max.getText().toString()),
                Float.parseFloat(desiredHumidity.getText().toString()),
                Float.parseFloat(humidityMax.getText().toString()),
                Float.parseFloat(desiredTemperature.getText().toString()),
                Float.parseFloat(temperatureMax.getText().toString()));


        Context context = getApplicationContext();
        String text = "Update values...";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
    }

    //TODO fix this
    private void validateValues(float desiredCO2, float CO2Max, float desiredHum, float humMax, float desiredTemp, float maxTemp){
        if((desiredTemp > 10 && desiredTemp < 50) && (desiredHum > 5 && desiredHum < 95) && (desiredCO2 > 5 && desiredCO2 < 95)){
            Intent intent = new Intent(FarmSettingsActivity.this, MonitorActivity.class);
            startActivity(intent);
        } else {
            info.setText("Something went wrong");
        }
    }

    private float getNumber(TextView textView) { return Float.parseFloat(textView.getText().toString()); }
}