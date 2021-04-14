package com.example.smartfarmandroidapp.viewmodel;

import androidx.lifecycle.LiveData;

import com.example.smartfarmandroidapp.model.Movement;
import com.example.smartfarmandroidapp.repository.MovementRepository;

import java.util.List;

public class MovementViewModel {
    private MovementRepository movementRepository;

    public MovementViewModel() {
        movementRepository = MovementRepository.getInstance();
    }

    public LiveData<List<Movement>> getAllMovementLevels() {
        return movementRepository.getAllMovementLevels();
    }

    public void insert(final Movement movement) {
        movementRepository.insert(movement);
    }

    public void deleteAllMovementLevels() {
        movementRepository.deleteAllMovementLevels();
    }
}
