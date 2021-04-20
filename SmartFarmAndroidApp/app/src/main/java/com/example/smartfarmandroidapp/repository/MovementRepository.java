package com.example.smartfarmandroidapp.repository;

import androidx.lifecycle.LiveData;

import com.example.smartfarmandroidapp.domain.Movement;
import com.example.smartfarmandroidapp.model.MovementDAO;

import java.util.List;

public class MovementRepository {

    private MovementDAO movementDAO;
    private static MovementRepository instance;

    private MovementRepository(){
        movementDAO = MovementDAO.getInstance();
    }

    public static MovementRepository getInstance(){
        if(instance == null)
            instance = new MovementRepository();

        return instance;
    }

    public LiveData<List<Movement>> getAllMovementLevels(){
        return movementDAO.getAllMovementLevels();
    }

    public void insert(Movement movement) {
        movementDAO.insert(movement);
    }

    public void deleteAllMovementLevels(){
        movementDAO.deleteAllMovementLevels();
    }
}
