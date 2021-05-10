package com.example.smartfarmandroidapp.MVVM.Repository.Monitor;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.smartfarmandroidapp.Domain.Preferences;
import com.example.smartfarmandroidapp.MVVM.RoomModel.DAO.PreferencesDAO;
import com.example.smartfarmandroidapp.MVVM.RoomModel.Database.PreferencesDatabase;

import java.util.List;

public class SettingsRepository implements ISettingsRepository {
    private PreferencesDatabase database;
    private PreferencesDAO preferencesDAO;
    private LiveData<List<Preferences>> preferences;

    public SettingsRepository(Application application) {
        database = PreferencesDatabase.getInstance(application);
        preferencesDAO = database.preferencesDAO();
        preferences = preferencesDAO.getPreferences(1234);
    }

    @Override
    public void savePreferences(Preferences preferences) {
        preferencesDAO.savePreferences(preferences);
    }

    @Override
    public LiveData<List<Preferences>> getPreferences(int userID) {
        return preferences;
    }
}
