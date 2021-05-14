package com.example.smartfarmandroidapp.MVVM.Repository.Monitor;

import android.app.Application;

import com.example.smartfarmandroidapp.MVVM.RoomModel.Models.Preferences.IPreferencesModel;
import com.example.smartfarmandroidapp.MVVM.RoomModel.Models.Preferences.PreferencesModel;
import com.example.smartfarmandroidapp.domain.Preferences;

import java.util.List;

import io.reactivex.Flowable;

public class SettingsRepository implements ISettingsRepository {
    private IPreferencesModel preferencesModel;

    public SettingsRepository(Application application) {
        preferencesModel = new PreferencesModel(application);
    }

    @Override
    public void savePreferences(Preferences preferences) {
        preferencesModel.savePreferences(preferences);
    }

    @Override
    public Flowable<List<Preferences>> getPreferences(int userID) {
        Flowable<List<Preferences>> preferences = preferencesModel.getPreferences(1234);
        if (preferences == null || preferences.blockingFirst().size() == 0) {
            preferencesModel.createPreferences(new Preferences(1234,0,0,0,0,0,0));
            preferences = preferencesModel.getPreferences(1234);
        }
        while (preferences.blockingFirst().size() == 0) {}
        return preferences;
    }
}
