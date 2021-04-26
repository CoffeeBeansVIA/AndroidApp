package com.example.smartfarmandroidapp.view;

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

import com.example.smartfarmandroidapp.R;
import com.example.smartfarmandroidapp.viewmodel.MonitorViewModel;

public class LoginActivity extends AppCompatActivity {

    private EditText emailText;
    private EditText passText;
    private Button loginButton;
    private TextView info;
    private int counter = 5;

    private MonitorViewModel monitorViewModel;

    private static final String MAIN_ACTIVITY = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        info = findViewById(R.id.errorTextView);
        emailText = findViewById(R.id.editTextEmailAddress);
        passText = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.loginButton);

        Log.d(MAIN_ACTIVITY, "onCreate was called");

        loginButton.setOnClickListener(view -> onClick(info));
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view) {
        boolean isValid = validate(emailText.getText().toString(), passText.getText().toString());
        if (isValid) {
            Context context = getApplicationContext();
            String text = "Logging in...";
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context, text, duration).show();
            Intent intent = new Intent(LoginActivity.this, MonitorActivity.class);
            startActivity(intent);
        }
    }

    @SuppressLint("SetTextI18n")
    //TODO user authentication, we must change this anyway
    private boolean validate(String email, String password) {
        if ((email.equals("user@email.com")) && (password.equals("new"))) {
            return true;
        }
        counter--;
        info.setText("No of attempts remaining: " + String.valueOf(counter));
        if (counter == 0) {
            loginButton.setEnabled(false);
        }
        return false;
    }
}