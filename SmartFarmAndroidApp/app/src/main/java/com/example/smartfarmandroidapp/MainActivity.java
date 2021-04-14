package com.example.smartfarmandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView textView;
    EditText editText;
    ProgressBar progressBar;
    TextView textViewProgress;

    private int progress = 0;

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        temperatureViewModel = new ViewModelProvider(this).get(TemperatureViewModel.class);
        temperatureViewModel.getAllTemperatureLevels().observe(this, new Observer<List<Temperature>>() {
            @Override
            public void onChanged(List<Temperature> temperatures) {
                if (!temperatures.isEmpty()) {
                    textView.setText("");
                    for (Temperature t : temperatures) {
                        textView.append(t.getTemperature() + "\n");
                    }
                } else {
                    textView.setText("Empty");
                }
            }
        });

        //
        textView = findViewById(R.id.textView);
        textViewProgress = findViewById(R.id.textViewProgress);
        progressBar = findViewById(R.id.progressBar);
        editText = findViewById(R.id.editTextMessage);

        Log.d(TAG, "onCreate was called");
    }

    public void login(View view){
        Context context = getApplicationContext();
        String text = "Sending message...";

        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

        Editable message = editText.getText();
        textView.setText(message);
    }
}