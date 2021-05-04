package com.example.smartfarmandroidapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.smartfarmandroidapp.Events.CO2Event;
import com.example.smartfarmandroidapp.Events.HumidityEvent;
import com.example.smartfarmandroidapp.Events.TemperatureEvent;
import com.example.smartfarmandroidapp.domain.CO2;
import com.example.smartfarmandroidapp.domain.Humidity;
import com.example.smartfarmandroidapp.domain.Preferences;
import com.example.smartfarmandroidapp.domain.Temperature;
import com.example.smartfarmandroidapp.model.PreferencesDAO;
import com.example.smartfarmandroidapp.model.PreferencesDatabase;
import com.example.smartfarmandroidapp.servicegenerator.FarmServiceGenerator;
import com.example.smartfarmandroidapp.webapi.CO2API;
import com.example.smartfarmandroidapp.webapi.HumidityAPI;
import com.example.smartfarmandroidapp.webapi.TemperatureAPI;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class Repository {
    private static Repository instance;
    private PreferencesDatabase preferencesDatabase;
    private PreferencesDAO preferencesDAO;

    public Repository() {
    }

    private Repository(Application application){
//        preferencesDatabase = PreferencesDatabase.getInstance(application);
//        preferencesDAO = preferencesDatabase.preferencesDAO();
    }

    public static synchronized Repository getInstance(){
        if(instance == null)
            instance = new Repository();
        return instance;
    }


    // API methods

    public void getCO2() {
        CO2API co2API = FarmServiceGenerator.getCO2API();
        Call<CO2> call = co2API.getCO2(3);
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

    public void getHumidity(){
        HumidityAPI humidityAPI = FarmServiceGenerator.getHumidityAPI();
        Call<Humidity> call = humidityAPI.getHumidity(2);
        call.enqueue(new Callback<Humidity>() {
            @Override
            public void onResponse(Call<Humidity> call, Response<Humidity> response) {
                if(response.isSuccessful())
                {
                    HumidityEvent event = new HumidityEvent();
                    event.setHumidity(response.body().getValue()+"");
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<Humidity> call, Throwable t) {

            }
        });
    }

    public void getTemperature(){
        TemperatureAPI temperatureAPI = FarmServiceGenerator.getTemperatureAPI();
        Call<Temperature> call = temperatureAPI.getTemperature(1);
        call.enqueue(new Callback<Temperature>() {
            @Override
            public void onResponse(Call<Temperature> call, Response<Temperature> response) {
                if(response.isSuccessful())
                {
                    TemperatureEvent event = new TemperatureEvent();
                    event.setTemperature(response.body().getValue()+"");
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<Temperature> call, Throwable t) {

            }
        });
    }

    // Model methods

    public void createPreferences(Preferences prefs) { new InsertPreferencesAsync(preferencesDAO).execute(prefs); }

    public void savePreferences(Preferences prefs) { new UpdatePreferencesAsync(preferencesDAO).execute(prefs); }

    public LiveData<List<Preferences>> getPreferences(int id) { return preferencesDAO.getPreferences(id); }

    // Inner classes

    private static class InsertPreferencesAsync extends AsyncTask<Preferences,Void,Void> {
        private PreferencesDAO preferencesDAO;
        public InsertPreferencesAsync(PreferencesDAO preferencesDAO) { this.preferencesDAO = preferencesDAO; }
        @Override
        protected Void doInBackground(Preferences... preferences) {
            preferencesDAO.createPreferences(preferences[0]);
            return null; }}

    public static class UpdatePreferencesAsync extends AsyncTask<Preferences,Void,Void> {
        private PreferencesDAO preferencesDAO;
        public UpdatePreferencesAsync(PreferencesDAO preferencesDAO) { this.preferencesDAO = preferencesDAO; }
        @Override
        protected Void doInBackground(Preferences... preferences) {
            preferencesDAO.savePreferences(preferences[0]);
            return null; }}
}
