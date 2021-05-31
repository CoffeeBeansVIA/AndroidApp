package com.example.smartfarmandroidapp.MVVM.RoomModel.Models.Preferences;


import com.example.smartfarmandroidapp.Domain.Preferences.Preferences_ROOM;

import java.util.List;

import io.reactivex.Flowable;

public interface IPreferencesModel {
    void createPreferences(Preferences_ROOM prefs);
    void savePreferences(Preferences_ROOM prefs);
    Flowable<List<Preferences_ROOM>> getPreferences(int id);
}
