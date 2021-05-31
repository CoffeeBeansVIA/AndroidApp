package com.example.smartfarmandroidapp.MVVM.RoomModel.Models.Preferences;


import com.example.smartfarmandroidapp.Domain.Preferences;

import java.util.List;

import io.reactivex.Flowable;

public interface IPreferencesModel {
    void createPreferences(Preferences prefs);
    void savePreferences(Preferences prefs);
    Flowable<List<Preferences>> getPreferences(int id);
}
