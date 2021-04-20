package com.example.smartfarmandroidapp.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.smartfarmandroidapp.domain.Movement;

import java.util.ArrayList;
import java.util.List;

public class MovementDAO {
    private MutableLiveData<List<Movement>> allMovementLevels;
    private static MovementDAO instance;

    private MovementDAO() {
        allMovementLevels = new MutableLiveData<>();
        List<Movement> newList = new ArrayList<>();
        allMovementLevels.setValue(newList);
    }

    public static MovementDAO getInstance() {
        if (instance == null) {
            instance = new MovementDAO();
        }
        return instance;
    }

    public LiveData<List<Movement>> getAllMovementLevels() {
        return allMovementLevels;
    }

    public void insert(Movement movement) {
        List<Movement> currentMovementLevel = allMovementLevels.getValue();
        currentMovementLevel.add(movement);
        allMovementLevels.setValue(currentMovementLevel);
    }

    public void deleteAllMovementLevels() {
        List<Movement> newList = new ArrayList<>();
        allMovementLevels.setValue(newList);
    }
}
