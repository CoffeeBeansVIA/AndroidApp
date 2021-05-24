package com.example.smartfarmandroidapp.domain;

import java.util.ArrayList;

public class Farm {
    private int id;
    private String name;
    private String location;
    private ArrayList<PlantKeeper> plantKeepers;
    private ArrayList<Sensor> Sensors;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public ArrayList<PlantKeeper> getPlantKeepers() { return plantKeepers; }
    public void setPlantKeepers(ArrayList<PlantKeeper> plantKeepers) { this.plantKeepers = plantKeepers; }
    public ArrayList<Sensor> getSensors() { return Sensors; }
    public void setSensors(ArrayList<Sensor> sensors) { Sensors = sensors; }

    public class PlantKeeper {
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String dateOfBirth;
        private String gender;

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }
        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getDateOfBirth() { return dateOfBirth; }
        public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }
    }

    public class Sensor {
        private int id;
        private String model;
        private String type;
        private String unit;
        private ArrayList<Integer> sensorSettings;

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getModel() { return model; }
        public void setModel(String model) { this.model = model; }
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public String getUnit() { return unit; }
        public void setUnit(String unit) { this.unit = unit; }
        public ArrayList<Integer> getSensorSettings() { return sensorSettings; }
        public void setSensorSettings(ArrayList<Integer> sensorSettings) { this.sensorSettings = sensorSettings; }
    }
}
