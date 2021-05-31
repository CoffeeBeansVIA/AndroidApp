package com.example.smartfarmandroidapp.EventsBusObject;

import com.example.smartfarmandroidapp.Domain.Measurments.Measurement;

import java.util.ArrayList;
import java.util.List;

public class HistoryMeasurmentEvent {
    private List<Measurement> lastMeasurements;

    public HistoryMeasurmentEvent() {
        this.lastMeasurements = new ArrayList<>();
    }

    public List<Measurement> getLastMeasurements() {
        return lastMeasurements;
    }

    public void setHistoryMeasurements(List<Measurement> lastMeasurements) {
        this.lastMeasurements = lastMeasurements;
    }
}
