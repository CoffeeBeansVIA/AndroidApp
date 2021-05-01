package com.example.smartfarmandroidapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.smartfarmandroidapp.Events.CO2Event;
import com.example.smartfarmandroidapp.R;
import com.example.smartfarmandroidapp.domain.CO2;
import com.example.smartfarmandroidapp.servicegenerator.FarmServiceGenerator;
import com.example.smartfarmandroidapp.viewmodel.MonitorViewModel;
import com.example.smartfarmandroidapp.webapi.ValueAPI;
import com.example.smartfarmandroidapp.webapi.HumidityAPI;
import com.example.smartfarmandroidapp.webapi.TemperatureAPI;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.internal.EverythingIsNonNull;

import static java.lang.String.format;

public class MonitorActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    private MonitorViewModel monitorViewModel;

    private TextView humidityValue,humidityPercentage,humidityTextView,temperatureValue,temperatureCelsius,temperatureTextView,co2progress ;

    private ProgressBar co2ProgressBar;

    private int progress = 50;

    private static final String MONITOR_ACTIVITY = "MonitorActivity";

    private ValueAPI valueAPI;
    private HumidityAPI humidityAPI;
    private TemperatureAPI temperatureAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        ((FarmServiceGenerator) getApplication()).getNetComponent().inject(this);

        monitorViewModel = new ViewModelProvider(this).get(MonitorViewModel.class);

        humidityValue = findViewById(R.id.humValue);
        temperatureValue = findViewById(R.id.tempValue);

        humidityTextView = findViewById(R.id.humidityTextView);
        temperatureTextView = findViewById(R.id.temperatureTextView);

        humidityPercentage = findViewById(R.id.humPercentage);
        temperatureCelsius = findViewById(R.id.tempCelsius);

        co2progress = findViewById(R.id.CO2progress);
        co2ProgressBar = findViewById(R.id.progressBar);
        setUpObserver();
        updateProgressBar();
        Log.d(MONITOR_ACTIVITY, "onCreate was called");
    }

    @SuppressLint("DefaultLocale")
    private void updateProgressBar(){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                    monitorViewModel.fetchMeasurementData();
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            };
        });
        thread.start();
    }

    private void setUpObserver(){
        monitorViewModel.getCO2Level().observe(this, CO2Level -> {
            String progress = CO2Level + "";
           int progressDigit =  (int)Double.parseDouble(CO2Level);
            co2ProgressBar.setProgress(progressDigit);
            co2progress.setText(progress);
        });
        monitorViewModel.getHumidity().observe(this, humidityLevel -> {
           humidityValue.setText(humidityLevel);
        });

        monitorViewModel.getTemperature().observe(this, temperatureLevel -> {
            temperatureValue.setText(temperatureLevel);
        } );
    }


    protected void getCO2API() {
       valueAPI =  retrofit.create(ValueAPI.class);
        Call<CO2> call = valueAPI.getCO2(3);
        call.enqueue(new Callback<CO2>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<CO2> call, Response<CO2> response) {
                if (response.isSuccessful()) {
                    CO2Event event = new CO2Event();
                    event.setCO2(response.body().getValue()+"");
                    EventBus.getDefault().post(event);
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<CO2> call, Throwable t) {
                t.printStackTrace();
            }

        });
    }

    protected void getValueAPI() {
        valueAPI = retrofit.create(ValueAPI.class);
        Call<CO2> call = valueAPI.getCO2(3);
        call.enqueue(new Callback<CO2>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<CO2> call, Response<CO2> response) {
                if (response.isSuccessful()) {
                    CO2Event event = new CO2Event();
                    event.setCO2(response.body().getValue()+"");
                    EventBus.getDefault().post(event);
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<CO2> call, Throwable t) {
                t.printStackTrace();
            }

        });
    }
//        if (co2API == null) {
//            co2API = new Retrofit.Builder()
//                    .baseUrl(url)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                    .create(CO2API.class);
//        }
//        return co2API;
//        CO2API co2API = r
 //   }
//
//    @Provides
//    @Singleton
//    public static HumidityAPI getHumidityAPI() {
//        if (humidityAPI == null) {
//            humidityAPI = new Retrofit.Builder()
//                    .baseUrl(url)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                    .create(HumidityAPI.class);
//        }
//        return humidityAPI;
//    }
//
//    @Provides
//    @Singleton
//    public static TemperatureAPI getTemperatureAPI() {
//        if (temperatureAPI == null) {
//            temperatureAPI = new Retrofit.Builder()
//                    .baseUrl(url)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                    .create(TemperatureAPI.class);
//        }
//        return temperatureAPI;
//    }
}
