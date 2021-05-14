package com.example.smartfarmandroidapp.MVVM.RoomModel.Models.Preferences;

import android.app.Application;
import android.os.AsyncTask;

import com.example.smartfarmandroidapp.MVVM.RoomModel.DAO.PreferencesDAO;
import com.example.smartfarmandroidapp.MVVM.RoomModel.Database.PreferencesDatabase;
import com.example.smartfarmandroidapp.domain.Preferences;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.Flowable;

public class PreferencesModel implements IPreferencesModel {

    private static PreferencesModel instance;
    private PreferencesDAO preferencesDAO;
    private final ExecutorService executorService;

    public PreferencesModel(Application application) {
        PreferencesDatabase preferencesDatabase = PreferencesDatabase.getInstance(application);
        preferencesDAO = preferencesDatabase.preferencesDAO();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized PreferencesModel getInstance(Application application) {
        if (instance == null) {
            instance = new PreferencesModel(application);
        }
        return instance;
    }


    @Override
    public void createPreferences(Preferences prefs) {
        executorService.execute(() -> new InsertPreferencesAsync(preferencesDAO).execute(prefs));
    }

    @Override
    public void savePreferences(Preferences prefs) {
        executorService.execute(() -> new UpdatePreferencesAsync(preferencesDAO).execute(prefs));
    }

    @Override
    public Flowable<List<Preferences>> getPreferences(int id) {
        return preferencesDAO.getPreferences(id);
    }


    private static class InsertPreferencesAsync extends AsyncTask<Preferences, Void, Void> {
        private PreferencesDAO preferencesDAO;

        public InsertPreferencesAsync(PreferencesDAO preferencesDAO) {
            this.preferencesDAO = preferencesDAO;
        }

        @Override
        protected Void doInBackground(Preferences... preferences) {
            preferencesDAO.createPreferences(preferences[0]);
            return null;
        }
    }
    public static class UpdatePreferencesAsync extends AsyncTask<Preferences,Void,Void> {
        private PreferencesDAO preferencesDAO;
        public UpdatePreferencesAsync(PreferencesDAO preferencesDAO) { this.preferencesDAO = preferencesDAO; }
        @Override
        protected Void doInBackground(Preferences... preferences) {
            preferencesDAO.savePreferences(preferences[0]);
            return null; }}
}
