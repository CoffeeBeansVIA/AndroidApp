package com.example.smartfarmandroidapp.MVVM.View.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.smartfarmandroidapp.MVVM.Viewmodel.FarmSettingsViewModel;
import com.example.smartfarmandroidapp.R;

public class FarmSettingsFragment extends Fragment {

    private EditText CO2Desired, CO2Deviation;
    private EditText temperatureDesired, temperatureDeviation;
    private EditText humidityDesired, humidityDeviation;
    private Button saveButton, returnButton;
    private TextView info;
    private View farmSettingsView;
    private FarmSettingsViewModel viewModel;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      farmSettingsView = inflater.inflate(R.layout.fragment_farm_settings,container,false);
        initializeFragmentsValues();
        return farmSettingsView;
    }

    private void initializeFragmentsValues() {
        viewModel = new ViewModelProvider(this).get(FarmSettingsViewModel.class);

        CO2Desired =  farmSettingsView.findViewById(R.id.desiredCO2);
        CO2Deviation = farmSettingsView.findViewById(R.id.maxCO2Dev);
        temperatureDesired = farmSettingsView.findViewById(R.id.desiredTemperature);
        temperatureDeviation = farmSettingsView.findViewById(R.id.maxTemperatureDev);
        humidityDesired = farmSettingsView.findViewById(R.id.desiredHumidity);
        humidityDeviation = farmSettingsView.findViewById(R.id.maxHumidityDev);

        loadValues();

        saveButton = farmSettingsView.findViewById(R.id.saveThresholdButton);
        returnButton = farmSettingsView.findViewById(R.id.returnFromTweakingButton);

        info = farmSettingsView.findViewById(R.id.errorTextView);

        saveButton.setOnClickListener(view -> onClickSave(info));

        setUpObserver();
    }


    private void loadValues(){
        /*
        Preferences preferences = viewModel.getPreferences().blockingFirst().get(0);
        CO2Desired.setText(preferences.getDesiredCO2() + "");
        CO2Deviation.setText(preferences.getDeviationCO2() + "");
        temperatureDesired.setText(preferences.getDesiredTemperature() + "");
        temperatureDeviation.setText(preferences.getDeviationTemperature() + "");
        humidityDesired.setText(preferences.getDesiredHumidity() + "");
        humidityDeviation.setText(preferences.getDeviationHumidity() + "");*/
    }

    @SuppressLint("SetTextI18n")
    private void onClickSave(View view){
        viewModel.savePreferences(Integer.parseInt(CO2Desired.getText().toString()),
                Integer.parseInt(CO2Deviation.getText().toString()),
                Integer.parseInt(humidityDesired.getText().toString()),
                Integer.parseInt(humidityDeviation.getText().toString()),
                Integer.parseInt(temperatureDesired.getText().toString()),
                Integer.parseInt(temperatureDeviation.getText().toString()));
        String text = "Update values...";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(getContext(), text, duration).show();
    }

    private void setUpObserver() {
        viewModel.getCO2Preferred().observe(getViewLifecycleOwner(), co2Desired -> {
            CO2Desired.setText(co2Desired);
        });

        viewModel.getCO2Deviation().observe(getViewLifecycleOwner(), co2Deviation -> {
            CO2Deviation.setText(co2Deviation);
        } );

        viewModel.getTemperaturePreferred().observe(getViewLifecycleOwner(), temperatureDesiredValue -> {
            temperatureDesired.setText(temperatureDesiredValue);
        });

        viewModel.getTemperatureDeviation().observe(getViewLifecycleOwner(), temperatureDeviationValue -> {
            temperatureDeviation.setText(temperatureDeviationValue);
        } );

        viewModel.getHumidityPreferred().observe(getViewLifecycleOwner(), humidityDesiredValue -> {
            humidityDesired.setText(humidityDesiredValue);
        });

        viewModel.getHumidityDeviation().observe(getViewLifecycleOwner(), humidityDeviationValue -> {
            humidityDeviation.setText(humidityDeviationValue);
        } );
    }
}
