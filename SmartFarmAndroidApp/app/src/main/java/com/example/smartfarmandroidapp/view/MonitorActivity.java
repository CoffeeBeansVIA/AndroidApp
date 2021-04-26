package com.example.smartfarmandroidapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.smartfarmandroidapp.R;
import com.example.smartfarmandroidapp.viewmodel.MonitorViewModel;

import static java.lang.String.format;

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
        monitorViewModel = new ViewModelProvider(this).get(MonitorViewModel.class);

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
