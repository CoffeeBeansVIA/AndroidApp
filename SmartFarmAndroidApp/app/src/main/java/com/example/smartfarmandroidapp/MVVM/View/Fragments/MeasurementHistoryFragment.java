package com.example.smartfarmandroidapp.MVVM.View.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartfarmandroidapp.R;

public class MeasurementHistoryFragment extends Fragment {
    private View measurementHistoryView;
    private SharedPreferences updateValuesPrefs;
    private SharedPreferences.Editor editor;
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
        return measurementHistoryView;
    }
}
