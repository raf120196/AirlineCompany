package com.epam.renat_farakhutdinov.java.lesson2.planes.airfreighters;

import com.epam.renat_farakhutdinov.java.lesson2.exceptions.InvalidPlainCharacteristicException;
import com.epam.renat_farakhutdinov.java.lesson2.planes.Plane;
import com.epam.renat_farakhutdinov.java.lesson2.planes.PlaneBrand;
import com.epam.renat_farakhutdinov.java.lesson2.planes.PlaneType;

/**
 * Created by Renat Farakhutdinov on 24.02.2018.
 */
public class Airfreighter implements Plane {
    private static PlaneType planeType = PlaneType.PASSENGER;

    private int id;
    private PlaneBrand producer;
    private String code;
    private double practicalCapacity;
    private int practicalRange;
    private int operatingSpeed;
    private int serviceCeiling;
    private double sizeOfFreightArea;
    private double activeLoad;

    public Airfreighter() {
    }

    public Airfreighter(int id, PlaneBrand producer, String code, double practicalCapacity, int practicalRange
            , int operatingSpeed, int serviceCeiling, double sizeOfFreightArea, double activeLoad) throws InvalidPlainCharacteristicException {

        if (practicalCapacity < 0 || practicalCapacity > 600000) {
            throw new InvalidPlainCharacteristicException(String.format("Invalid \"Practical Capacity\" " +
                    "parameter for plain with id = %d", id));
        }

        this.id = id;
        this.producer = producer;
        this.code = code;
        this.practicalCapacity = practicalCapacity;
        this.practicalRange = practicalRange;
        this.operatingSpeed = operatingSpeed;
        this.serviceCeiling = serviceCeiling;
        this.sizeOfFreightArea = sizeOfFreightArea;
        this.activeLoad = activeLoad;
    }

    @Override
    public PlaneBrand getBrand() {
        return producer;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public PlaneType getType() {
        return planeType;
    }

    @Override
    public double getPracticalCapacity() {
        return practicalCapacity;
    }

    @Override
    public int getPracticalRange() {
        return practicalRange;
    }

    @Override
    public int getOperatingSpeed() {
        return operatingSpeed;
    }

    @Override
    public int getServiceCeiling() {
        return serviceCeiling;
    }

    public void setPracticalCapacity(double practicalCapacity) {
        this.practicalCapacity = practicalCapacity;
    }

    public void setPracticalRange(int practicalRange) {
        this.practicalRange = practicalRange;
    }

    public void setOperatingSpeed(int operatingSpeed) {
        this.operatingSpeed = operatingSpeed;
    }

    public void setServiceCeiling(int serviceCeiling) {
        this.serviceCeiling = serviceCeiling;
    }

    public String getPlaneName() {
        return String.valueOf(producer.getPlaneName() + "-" + code);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = planeType.getDescription().hashCode() + getPlaneName().hashCode();
        return prime * (hash + (int) activeLoad * operatingSpeed + id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Airfreighter o = (Airfreighter) obj;

        return this.id == o.id && this.producer == o.producer && this.code.equals(o.code) && this.practicalRange == o.practicalRange
                && this.practicalCapacity == o.practicalCapacity && this.operatingSpeed == o.operatingSpeed
                && this.serviceCeiling == o.serviceCeiling && this.activeLoad == o.activeLoad && this.sizeOfFreightArea == o.sizeOfFreightArea;
    }

    @Override
    public String toString() {
        return String.format("Airfreighter [name = \"%s\"; id = %d; operating speed = %d; service ceiling = %d; practical capacity = %.2f; " +
                        "practical range = %d; active load = %.2f]", getPlaneName(), id, operatingSpeed, serviceCeiling, practicalCapacity,
                practicalRange, activeLoad);
    }

    @Override
    public int compareTo(Plane o) {
        if (this.getPracticalRange() > o.getPracticalRange()) {
            return 1;
        }

        if (this.getPracticalRange() < o.getPracticalRange()) {
            return -1;
        }

        return 0;
    }
}
