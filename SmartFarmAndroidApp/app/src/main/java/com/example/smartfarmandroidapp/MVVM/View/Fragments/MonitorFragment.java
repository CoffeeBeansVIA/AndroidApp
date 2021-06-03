package com.example.smartfarmandroidapp.MVVM.View.Fragments;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.smartfarmandroidapp.MVVM.Viewmodel.MonitorViewModel;
import com.example.smartfarmandroidapp.R;

import java.util.Objects;

import static com.example.smartfarmandroidapp.NotificationChannel.App.CHANNEL_ID;

public class MonitorFragment extends Fragment {

    private MonitorViewModel monitorViewModel;

    private NotificationManagerCompat notificationManager;

    private TextView info, humidityValue, humidityPercentage, humidityTextView, temperatureValue, temperatureCelsius, temperatureTextView, co2progress;

    private ProgressBar co2ProgressBar;
    private SharedPreferences updateValuesPrefs;
    private SharedPreferences.Editor editor;

    private Button notificationButton;

    private int progress = 50;
    private View monitorView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        monitorView = inflater.inflate(R.layout.fragment_monitor, container, false);

        updateValuesPrefs = requireActivity().getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        editor = updateValuesPrefs.edit();
        editor.putString("isNeededToUpdate", "true");
        editor.apply();
        initializeFragmentsValues();
        return monitorView;
    }

    private void initializeFragmentsValues() {

        monitorViewModel = new ViewModelProvider(this).get(MonitorViewModel.class);

        humidityValue = monitorView.findViewById(R.id.humValue);
        temperatureValue = monitorView.findViewById(R.id.tempValue);

        humidityTextView = monitorView.findViewById(R.id.humidityTextView);
        temperatureTextView = monitorView.findViewById(R.id.temperatureTextView);

        humidityPercentage = monitorView.findViewById(R.id.humPercentage);
        temperatureCelsius = monitorView.findViewById(R.id.tempCelsius);

        co2progress = monitorView.findViewById(R.id.CO2progress);
        co2ProgressBar = monitorView.findViewById(R.id.progressBar);

        Button button = monitorView.findViewById(R.id.testButton);
        button.setOnClickListener(v ->
        {
            editor.putString("isNeededToUpdate", "false");
            editor.apply();
            Navigation.findNavController(monitorView).navigate(R.id.action_monitorFragment_to_farmSettingsFragment);
        });

        setUpObserver();

        updateProgressBar();

        // For passing notifications
        notificationManager = NotificationManagerCompat.from(requireActivity());

        notificationButton = monitorView.findViewById(R.id.testNotificationButton);
     //   notificationButton.setOnClickListener(v -> checkIfValueIsValid());

        info = monitorView.findViewById(R.id.notificationTextView);

    }

    // Notification Channel
    public void sendOnChannel(View v, String warning){

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            CharSequence name = getString(R.string.channel_name);
//            String description = getString(R.string.channel_description);
//            int importance = NotificationManager.IMPORTANCE_HIGH;
//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
//            channel.setDescription(description);
//            channel.setLightColor(1);
//            channel.shouldVibrate();
//            // Register the channel with the system; you can't change the importance
//            // or other notification behaviors after this
//            NotificationManager notificationManager = getSystemService(NotificationManager.class);
//            if (notificationManager != null) {
//                notificationManager.createNotificationChannel(channel);
//            }
//        }
        Notification notification = new NotificationCompat.Builder(getActivity(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_warning)
                .setContentTitle("Alert")
                .setContentText(warning)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);


    }

    public void checkIfValueIsValid(){
        //TODO to pass notifications when the plant's environment reaches dangerous levels
        monitorViewModel.fetchSettingsData();
       // sendOnChannel(info);
    }

    private void updateProgressBar() {
        Thread thread = new Thread(() -> {
            while (updateValuesPrefs.getString("isNeededToUpdate", "false").equals("true")) {
                monitorViewModel.fetchMeasurementData();
                monitorViewModel.fetchSettingsData();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private void setUpObserver() {
        monitorViewModel.getCO2Level().observe(getViewLifecycleOwner(), CO2Level -> {
            String progress = CO2Level + "";
            int progressDigit = (int) Double.parseDouble(CO2Level);
            co2ProgressBar.setProgress(progressDigit);
            co2progress.setText(progress);
        });
        monitorViewModel.getHumidity().observe(getViewLifecycleOwner(), humidityLevel -> {
            humidityValue.setText(humidityLevel);
        });

        monitorViewModel.getTemperature().observe(getViewLifecycleOwner(), temperatureLevel -> {
            temperatureValue.setText(temperatureLevel);
        });

        monitorViewModel.getWarning().observe(getViewLifecycleOwner(), warning ->{
            System.out.println("Warning: " + warning);
            info.setText(warning);
            info.setVisibility(View.VISIBLE);
            sendOnChannel(info, warning);
        });

       // monitorViewModel
    }
}
