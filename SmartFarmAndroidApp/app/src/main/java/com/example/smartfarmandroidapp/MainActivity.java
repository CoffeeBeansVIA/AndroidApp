package com.example.smartfarmandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.smartfarmandroidapp.model.Temperature;
import com.example.smartfarmandroidapp.viewmodel.CO2ViewModel;
import com.example.smartfarmandroidapp.viewmodel.HumidityViewModel;
import com.example.smartfarmandroidapp.viewmodel.MovementViewModel;
import com.example.smartfarmandroidapp.viewmodel.TemperatureViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //TODO add viewmodels
    private TemperatureViewModel temperatureViewModel;
    private HumidityViewModel humidityViewModel;
    private CO2ViewModel co2ViewModel;
    private MovementViewModel movementViewModel; //TODO if we decide that we don't need it, just delete it

    // CO2 Level ProgressBar
    TextView temperatureTextView;
    ProgressBar progressBar;
    TextView textViewProgress;

    private int progress = 0;

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //temperatureViewModel = new ViewModelProvider(this).get(TemperatureViewModel.class); //TODO

        temperatureViewModel.getAllTemperatureLevels().observe(this, new Observer<List<Temperature>>() {
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
        });


        temperatureTextView = findViewById(R.id.temperatureTextView);
        textViewProgress = findViewById(R.id.textViewProgress);
        progressBar = findViewById(R.id.progressBar);

        Log.d(TAG, "onCreate was called");
    }
}