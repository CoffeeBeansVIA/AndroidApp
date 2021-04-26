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
        monitorViewModel = new MonitorViewModel();

        humidityValue = findViewById(R.id.humValue);
        temperatureValue = findViewById(R.id.tempValue);

        humidityTextView = findViewById(R.id.humidityTextView);
        temperatureTextView = findViewById(R.id.temperatureTextView);

        humidityPercentage = findViewById(R.id.humPercentage);
        temperatureCelsius = findViewById(R.id.tempCelsius);

        co2progress = findViewById(R.id.CO2progress);
        co2ProgressBar = findViewById(R.id.progressBar);



        updateProgressBar();

        Log.d(MONITOR_ACTIVITY, "onCreate was called");
    }

    @SuppressLint("DefaultLocale")
    private void updateProgressBar(){
        String str = progress + "";

        co2ProgressBar.setProgress(progress);
        co2progress.setText(str);
    }
}
