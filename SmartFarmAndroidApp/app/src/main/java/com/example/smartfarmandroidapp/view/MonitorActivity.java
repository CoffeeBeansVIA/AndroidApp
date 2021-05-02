package com.example.smartfarmandroidapp.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartfarmandroidapp.R;
import com.example.smartfarmandroidapp.viewmodel.MonitorViewModel;

public class MonitorActivity extends AppCompatActivity {

    private MonitorViewModel monitorViewModel;

    private TextView humidityValue,humidityPercentage,humidityTextView,temperatureValue,temperatureCelsius,temperatureTextView,co2progress ;

    private ProgressBar co2ProgressBar;

    private int progress = 50;

    private static final String MONITOR_ACTIVITY = "MonitorActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        monitorViewModel = new MonitorViewModel(getApplication());

        humidityValue = findViewById(R.id.humValue);
        temperatureValue = findViewById(R.id.tempValue);

        humidityTextView = findViewById(R.id.humidityTextView);
        temperatureTextView = findViewById(R.id.temperatureTextView);

        humidityPercentage = findViewById(R.id.humPercentage);
        temperatureCelsius = findViewById(R.id.tempCelsius);

        co2progress = findViewById(R.id.CO2progress);
        co2ProgressBar = findViewById(R.id.progressBar);
        setUpObserver();
        updateProgressBar();
        Log.d(MONITOR_ACTIVITY, "onCreate was called");

        Button testButton = findViewById(R.id.testButton);
        testButton.setOnClickListener(v -> {
            Intent intent = new Intent(MonitorActivity.this, FarmSettingsActivity.class);
            startActivity(intent);
        });
    }




    @SuppressLint("DefaultLocale")
    private void updateProgressBar(){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                    monitorViewModel.fetchMeasurementData();
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            };
        });
        thread.start();
    }

    private void setUpObserver(){
        monitorViewModel.getCO2Level().observe(this, CO2Level -> {
            String progress = CO2Level + "";
           int progressDigit =  (int)Double.parseDouble(CO2Level);
            co2ProgressBar.setProgress(progressDigit);
            co2progress.setText(progress);
        });
        monitorViewModel.getHumidity().observe(this, humidityLevel -> {
           humidityValue.setText(humidityLevel);
        });

        monitorViewModel.getTemperature().observe(this, temperatureLevel -> {
            temperatureValue.setText(temperatureLevel);
        } );
    }
}
