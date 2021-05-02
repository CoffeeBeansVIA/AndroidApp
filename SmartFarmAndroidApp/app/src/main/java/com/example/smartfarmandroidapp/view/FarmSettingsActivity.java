package com.example.smartfarmandroidapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartfarmandroidapp.R;
import com.example.smartfarmandroidapp.domain.Preferences;
import com.example.smartfarmandroidapp.viewmodel.MonitorViewModel;

public class FarmSettingsActivity extends AppCompatActivity {
    private EditText CO2Desired, CO2Deviation;
    private EditText temperatureDesired, temperatureDeviation;
    private EditText humidityDesired, humidityDeviation;
    private Button saveButton, returnButton;
    private TextView info;
    private MonitorViewModel viewModel;

    private static final String FARM_SETTINGS_ACTIVITY = "FarmSettingsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_settings);
        viewModel = new MonitorViewModel(getApplication());

        CO2Desired = findViewById(R.id.desiredCO2);
        CO2Deviation = findViewById(R.id.maxCO2Dev);
        temperatureDesired = findViewById(R.id.desiredTemperature);
        temperatureDeviation = findViewById(R.id.maxTemperatureDev);
        humidityDesired = findViewById(R.id.desiredHumidity);
        humidityDeviation = findViewById(R.id.maxHumidityDev);

        loadValues();

        saveButton = findViewById(R.id.saveThresholdButton);
        returnButton = findViewById(R.id.returnFromTweakingButton);

        info = findViewById(R.id.errorTextView);

        saveButton.setOnClickListener(view -> onClickSave(info));

        returnButton.setOnClickListener(v -> { finish(); });

        Log.d(FARM_SETTINGS_ACTIVITY, "onCreate was called");
    }

    private void loadValues(){
        Preferences preferences = viewModel.getPreferences().getValue().get(0);
        CO2Desired.setText(preferences.getDesiredCO2() + "");
        CO2Deviation.setText(preferences.getDeviationCO2() + "");
        temperatureDesired.setText(preferences.getDesiredTemperature() + "");
        temperatureDeviation.setText(preferences.getDeviationTemperature() + "");
        humidityDesired.setText(preferences.getDesiredHumidity() + "");
        humidityDeviation.setText(preferences.getDeviationHumidity() + "");
    }

    @SuppressLint("SetTextI18n")
    private void onClickSave(View view){
        viewModel.savePreferences(Integer.parseInt(CO2Desired.getText().toString()),
                Integer.parseInt(CO2Deviation.getText().toString()),
                Integer.parseInt(humidityDesired.getText().toString()),
                Integer.parseInt(humidityDeviation.getText().toString()),
                Integer.parseInt(temperatureDesired.getText().toString()),
                Integer.parseInt(temperatureDeviation.getText().toString()));

        Context context = getApplicationContext();
        String text = "Update values...";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
    }
}