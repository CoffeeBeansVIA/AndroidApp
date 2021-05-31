package com.example.smartfarmandroidapp.MVVM.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.smartfarmandroidapp.Enums.SensorEnum;
import com.example.smartfarmandroidapp.EventsBusObject.HistoryMeasurmentEvent;
import com.example.smartfarmandroidapp.MVVM.Repository.HistoryMeasurment.HistoryMeasurementRepository;
import com.example.smartfarmandroidapp.MVVM.Repository.HistoryMeasurment.IHistoryMeasurementRepository;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

public class HistoryMeasurmentViewModel extends AndroidViewModel {

    private IHistoryMeasurementRepository historyMeasurementRepository;

    public HistoryMeasurmentViewModel(@NonNull @NotNull Application application) {
        super(application);
        EventBus.getDefault().register(this);
        historyMeasurementRepository = new HistoryMeasurementRepository(application);
    }

    @Subscribe
    public void onHistoryMeasurementEvent(HistoryMeasurmentEvent historyMeasurmentEvent){
        System.out.println(historyMeasurmentEvent.getLastMeasurements().size());
    }


    public void getMeasurements(SensorEnum sensorEnum) {
       historyMeasurementRepository.getMeasurements(sensorEnum);
    }
}
