package com.example.smartfarmandroidapp.EventsBusObject;

import com.example.smartfarmandroidapp.domain.Preferences;

public class PreferencesEvent {
    private Preferences preferences;

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }
}
