package com.example.smartfarmandroidapp.servicegenerator;

import com.example.smartfarmandroidapp.module.ApiModule;
import com.example.smartfarmandroidapp.module.AppModule;
import com.example.smartfarmandroidapp.view.MonitorActivity;

import javax.inject.Singleton;

import dagger.Component;

// Definition of the Application graph
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface FarmServiceComponent {
    void inject(MonitorActivity activity);
}
