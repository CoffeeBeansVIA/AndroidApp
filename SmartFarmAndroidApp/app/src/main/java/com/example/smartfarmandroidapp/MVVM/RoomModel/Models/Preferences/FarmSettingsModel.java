package com.example.smartfarmandroidapp.MVVM.RoomModel.Models.Preferences;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.smartfarmandroidapp.Domain.Room.Settings;
import com.example.smartfarmandroidapp.MVVM.RoomModel.DAO.FarmSettingsDAO;
import com.example.smartfarmandroidapp.MVVM.RoomModel.Database.SmartFarmDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FarmSettingsModel implements IFarmSettingsModel {

    private static FarmSettingsModel instance;
    private FarmSettingsDAO farmSettingsDAO;
    private final ExecutorService executorService;

    public FarmSettingsModel(Application application) {
        SmartFarmDatabase smartFarmDatabase = SmartFarmDatabase.getInstance(application);
        farmSettingsDAO = smartFarmDatabase.preferencesDAO();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized FarmSettingsModel getInstance(Application application) {
        if (instance == null) {
            instance = new FarmSettingsModel(application);
        }
        return instance;
    }


    @Override
    public void createSettings(Settings prefs) {
        executorService.execute(() ->
                new InsertPreferencesAsync(farmSettingsDAO).execute(prefs));
    }

    @Override
    public void saveSettings(Settings prefs) {
        executorService.execute(() ->
                new UpdatePreferencesAsync(farmSettingsDAO).execute(prefs));
    }

    @Override
    public LiveData<List<Settings>> getSettings(int id) {
        //TODO must have an executorAsync as well
        return farmSettingsDAO.getPreferences(id);
//        executorService.execute(() -> preferencesDAO.getPreferences(id));
//        return null;
    }


    private static class InsertPreferencesAsync extends AsyncTask<Settings, Void, Void> {
        private FarmSettingsDAO farmSettingsDAO;

        public InsertPreferencesAsync(FarmSettingsDAO farmSettingsDAO) {
            this.farmSettingsDAO = farmSettingsDAO;
        }

        @Override
        protected Void doInBackground(Settings... preferences) {
            farmSettingsDAO.createPreferences(preferences[0]);
            return null;
        }
    }
    public static class UpdatePreferencesAsync extends AsyncTask<Settings,Void,Void> {
        private FarmSettingsDAO farmSettingsDAO;
        public UpdatePreferencesAsync(FarmSettingsDAO farmSettingsDAO) { this.farmSettingsDAO = farmSettingsDAO; }
        @Override
        protected Void doInBackground(Settings... preferences) {
            farmSettingsDAO.savePreferences(preferences[0]);
            return null; }}
}
