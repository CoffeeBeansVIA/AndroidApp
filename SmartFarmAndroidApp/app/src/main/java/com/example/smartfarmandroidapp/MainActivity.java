package com.example.smartfarmandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

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

import com.example.smartfarmandroidapp.viewmodel.CO2ViewModel;
import com.example.smartfarmandroidapp.viewmodel.HumidityViewModel;
import com.example.smartfarmandroidapp.viewmodel.TemperatureViewModel;

public class MainActivity extends AppCompatActivity {

    EditText emailText;
    EditText passText;
    Button loginButton;
    TextView info;
    private int counter = 5;

    CO2ViewModel co2ViewModel;
    TemperatureViewModel temperatureViewModel;
    HumidityViewModel humidityViewModel;

    private static final String MAIN_ACTIVITY = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.errorTextView);
        emailText = findViewById(R.id.editTextEmailAddress);
        passText = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.loginButton);

        temperatureViewModel = new ViewModelProvider(this).get(TemperatureViewModel.class);
        humidityViewModel = new ViewModelProvider(this).get(HumidityViewModel.class);
        co2ViewModel = new ViewModelProvider(this).get(CO2ViewModel.class);

        Log.d(MAIN_ACTIVITY, "onCreate was called");

        loginButton.setOnClickListener(view -> onClick(info));
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view){
        validate(emailText.getText().toString(), passText.getText().toString());

        Context context = getApplicationContext();
        String text = "Logging in...";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
        Intent intent = new Intent(MainActivity.this, MonitorActivity.class);
        startActivity(intent);
    }

    @SuppressLint("SetTextI18n")
    //TODO user authentication, we must change this anyway
    private void validate(String email, String password){
        if((email.equals("user@email.com")) && (password.equals("new"))){
            Intent intent = new Intent(MainActivity.this, MonitorActivity.class);
            startActivity(intent);
        }
        else{
            counter--;

            info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                loginButton.setEnabled(false);
            }
        }
    }
}