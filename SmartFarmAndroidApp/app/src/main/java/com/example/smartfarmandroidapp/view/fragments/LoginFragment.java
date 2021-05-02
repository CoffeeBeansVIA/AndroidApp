package com.example.smartfarmandroidapp.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.smartfarmandroidapp.R;
import com.example.smartfarmandroidapp.viewmodel.MonitorViewModel;

public class LoginFragment extends Fragment {
    private EditText emailText;
    private EditText passText;
    private Button loginButton;
    private TextView info;
    private int counter = 5;
    private View loginView;
    private MonitorViewModel monitorViewModel;






    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loginView = inflater.inflate(R.layout.fragment_login,container,false);
        initializeFragmentsValues();
        loginButton.setOnClickListener(view -> {
            Navigation.findNavController(loginView).navigate(R.id.action_loginFragment_to_monitorFragment);
        });

        return loginView;
    }

    private void initializeFragmentsValues() {
        loginButton= loginView.findViewById(R.id.loginButton);
        emailText = loginView.findViewById(R.id.editTextEmailAddress);
        passText = loginView.findViewById(R.id.editTextPassword);
        info = loginView.findViewById(R.id.errorTextView);

    }

}
