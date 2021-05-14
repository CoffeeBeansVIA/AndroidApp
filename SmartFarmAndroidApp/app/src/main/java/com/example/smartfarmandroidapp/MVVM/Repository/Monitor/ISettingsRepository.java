package com.example.smartfarmandroidapp.MVVM.Repository.Monitor;

import com.example.smartfarmandroidapp.domain.Preferences;

import java.util.List;

import io.reactivex.Flowable;

public interface ISettingsRepository {
    void savePreferences(Preferences preferences);
    Flowable<List<Preferences>> getPreferences(int userID);
}
