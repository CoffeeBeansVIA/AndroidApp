package com.example.smartfarmandroidapp.EventsBusObject;

import com.example.smartfarmandroidapp.domain.Preferences;

import java.util.ArrayList;

public class PreferencesEvent {
    private Preferences preferences;
    private ArrayList<Preferences> preferencesArrayList;

    public Preferences getPreferences() {
        return preferences;
    }
    public ArrayList<Preferences> getPreferencesArrayList() { return preferencesArrayList; }
    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }
    public void setPreferencesList(ArrayList<Preferences> preferencesArrayList) { this.preferencesArrayList = preferencesArrayList; }
}
