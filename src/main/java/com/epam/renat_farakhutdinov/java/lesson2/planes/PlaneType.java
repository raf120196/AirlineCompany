package com.epam.renat_farakhutdinov.java.lesson2.planes;

/**
 * Created by Renat Farakhutdinov on 24.02.2018.
 */
public enum PlaneType {
    AIRFREIGHTER("Airfreighters plane for cargo transportation"),
    PASSENGER("Passenger jet");

    private String description;

    PlaneType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
