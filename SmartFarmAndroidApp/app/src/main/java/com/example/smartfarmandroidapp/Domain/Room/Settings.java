package com.example.smartfarmandroidapp.Domain.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "farm_settings_table")
public class Settings {
    @PrimaryKey
    int userID;
    @ColumnInfo(defaultValue = "0")
    int desiredCO2;
    @ColumnInfo(defaultValue = "0")
    int deviationCO2;
    @ColumnInfo(defaultValue = "0")
    int desiredTemperature;
    @ColumnInfo(defaultValue = "0")
    int deviationTemperature;
    @ColumnInfo(defaultValue = "0")
    int desiredHumidity;
    @ColumnInfo(defaultValue = "0")
    int deviationHumidity;

    public Settings(int userID, int desiredCO2, int deviationCO2, int desiredTemperature, int deviationTemperature, int desiredHumidity, int deviationHumidity) {
        this.userID = userID;
        this.desiredCO2 = desiredCO2;
        this.deviationCO2 = deviationCO2;
        this.desiredTemperature = desiredTemperature;
        this.deviationTemperature = deviationTemperature;
        this.desiredHumidity = desiredHumidity;
        this.deviationHumidity = deviationHumidity;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getDesiredCO2() {
        return desiredCO2;
    }

    public void setDesiredCO2(int desiredCO2) {
        this.desiredCO2 = desiredCO2;
    }

    public int getDeviationCO2() {
        return deviationCO2;
    }

    public void setDeviationCO2(int deviationCO2) {
        this.deviationCO2 = deviationCO2;
    }

    public int getDesiredTemperature() {
        return desiredTemperature;
    }

    public void setDesiredTemperature(int desiredTemperature) {
        this.desiredTemperature = desiredTemperature;
    }

    public int getDeviationTemperature() {
        return deviationTemperature;
    }

    public void setDeviationTemperature(int deviationTemperature) {
        this.deviationTemperature = deviationTemperature;
    }

    public int getDesiredHumidity() {
        return desiredHumidity;
    }

    public void setDesiredHumidity(int desiredHumidity) {
        this.desiredHumidity = desiredHumidity;
    }

    public int getDeviationHumidity() {
        return deviationHumidity;
    }

    public void setDeviationHumidity(int deviationHumidity) {
        this.deviationHumidity = deviationHumidity;
    }
}
