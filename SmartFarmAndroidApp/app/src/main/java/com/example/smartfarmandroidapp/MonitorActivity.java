package com.example.smartfarmandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.smartfarmandroidapp.domain.Temperature;
import com.example.smartfarmandroidapp.viewmodel.CO2ViewModel;
import com.example.smartfarmandroidapp.viewmodel.HumidityViewModel;
import com.example.smartfarmandroidapp.viewmodel.TemperatureViewModel;

import java.util.List;

import static java.lang.String.format;

public class MonitorActivity extends AppCompatActivity {

    private TemperatureViewModel temperatureViewModel;
    private HumidityViewModel humidityViewModel;
    private CO2ViewModel co2ViewModel;

    TextView humidityValue;
    TextView humidityPercentage;
    TextView humidityTextView;
    TextView temperatureValue;
    TextView temperatureCelsius;
    TextView temperatureTextView;

    TextView co2progress;
    ProgressBar co2ProgressBar;

    //private int progress = 0;

    private static final String MONITOR_ACTIVITY = "MonitorActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        humidityValue = findViewById(R.id.humValue);
        temperatureValue = findViewById(R.id.tempValue);

        humidityTextView = findViewById(R.id.humidityTextView);
        temperatureTextView = findViewById(R.id.temperatureTextView);

        humidityPercentage = findViewById(R.id.humPercentage);
        temperatureCelsius = findViewById(R.id.tempCelsius);

        co2progress = findViewById(R.id.CO2progress);
        co2ProgressBar = findViewById(R.id.progressBar);

        temperatureViewModel = new ViewModelProvider(this).get(TemperatureViewModel.class);
        humidityViewModel = new ViewModelProvider(this).get(HumidityViewModel.class);
        co2ViewModel = new ViewModelProvider(this).get(CO2ViewModel.class);

        //updateProgressBar();

        Log.d(MONITOR_ACTIVITY, "onCreate was called");

      /*  temperatureViewModel.getAllTemperatureLevels().observe(this, new Observer<List<Temperature>>() {
            @Override
            public void onChanged(List<Temperature> temperatures) {
                if (!temperatures.isEmpty()) {
                    temperatureTextView.setText("");
                    for (Temperature t : temperatures) {
                        temperatureTextView.append(t.getTemperature() + "\n");
                    }
                } else {
                    temperatureTextView.setText("Empty");
                }
            }
        });*/
    }

    /*@SuppressLint("DefaultLocale")
    private void updateProgressBar(){
        co2ProgressBar.setProgress(progress);
        co2progress.setText(format("%d%s", progress));
    }*/
}
