package com.example.smartfarmandroidapp.MVVM.View.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.smartfarmandroidapp.Enums.SensorEnum;
import com.example.smartfarmandroidapp.MVVM.Viewmodel.FarmSettingsViewModel;
import com.example.smartfarmandroidapp.MVVM.Viewmodel.HistoryMeasurmentViewModel;
import com.example.smartfarmandroidapp.R;

public class MeasurementHistoryFragment extends Fragment {
    private View measurementHistoryView;
    private Spinner dropdown;
    private SharedPreferences updateValuesPrefs;
    private SharedPreferences.Editor editor;
    private HistoryMeasurmentViewModel historyMeasurmentViewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        updateValuesPrefs = requireActivity().getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        editor = updateValuesPrefs.edit();
        editor.putString("isNeededToUpdate", "false");
        editor.apply();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        measurementHistoryView = inflater.inflate(R.layout.fragment_measurement_history, container, false);
        initialize();
      //  historyMeasurmentViewModel.getMeasurements(SensorEnum.TEMPERATURE);
        return measurementHistoryView;
    }
    public void initialize(){
        historyMeasurmentViewModel = new ViewModelProvider(this).get(HistoryMeasurmentViewModel.class);
        dropdown = measurementHistoryView.findViewById(R.id.spinner_fragment_measurments_history);
        String[] items = new String[]{"Temperature", "Humidity", "CO2"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_measurement_history, items);
        dropdown.setAdapter(adapter);
    }
}
