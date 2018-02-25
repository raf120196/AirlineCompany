package com.epam.renat_farakhutdinov.java.lesson2.planes.passenger_jets;

import com.epam.renat_farakhutdinov.java.lesson2.planes.Plane;
import com.epam.renat_farakhutdinov.java.lesson2.planes.PlaneBrand;
import com.epam.renat_farakhutdinov.java.lesson2.planes.PlaneType;

/**
 * Created by Renat Farakhutdinov on 25.02.2018.
 */
public class PassengerJet implements Plane {
    private static PlaneType planeType = PlaneType.PASSENGER;

    private int id;
    private PlaneBrand producer;
    private String code;
    private double practicalCapacity;
    private int practicalRange;
    private int operatingSpeed;
    private int serviceCeiling;
    private int seatingCapacityInEconomyClass;
    private int seatingCapacityInBusinessClass;
    private double revenueLoad;

    public PassengerJet() {
    }

    public PassengerJet(int id, PlaneBrand producer, String code, double practicalCapacity, int practicalRange
            , int operatingSpeed, int serviceCeiling, int seatingCapacityInEconomyClass
            , int seatingCapacityInBusinessClass, double revenueLoad) {
        this.id = id;
        this.producer = producer;
        this.code = code;
        this.practicalCapacity = practicalCapacity;
        this.practicalRange = practicalRange;
        this.operatingSpeed = operatingSpeed;
        this.serviceCeiling = serviceCeiling;
        this.seatingCapacityInEconomyClass = seatingCapacityInEconomyClass;
        this.seatingCapacityInBusinessClass = seatingCapacityInBusinessClass;
        this.revenueLoad = revenueLoad;
    }

    public PassengerJet(int id, PlaneBrand producer, String code) {
        this.id = id;
        this.producer = producer;
        this.code = code;
        this.practicalCapacity = 0;
        this.practicalRange = 0;
        this.operatingSpeed = 0;
        this.serviceCeiling = 0;
        this.seatingCapacityInEconomyClass = 0;
        this.seatingCapacityInBusinessClass = 0;
        this.revenueLoad = 0;
    }

    public int getSeatingCapacityInEconomyClass() {
        return seatingCapacityInEconomyClass;
    }

    public int getSeatingCapacityInBusinessClass() {
        return seatingCapacityInBusinessClass;
    }

    public double getRevenueLoad() {
        return revenueLoad;
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

    public void setSeatingCapacityInEconomyClass(int seatingCapacityInEconomyClass) {
        this.seatingCapacityInEconomyClass = seatingCapacityInEconomyClass;
    }

    public void setSeatingCapacityInBusinessClass(int seatingCapacityInBusinessClass) {
        this.seatingCapacityInBusinessClass = seatingCapacityInBusinessClass;
    }

    public void setRevenueLoad(double revenueLoad) {
        this.revenueLoad = revenueLoad;
    }

    public int getCommonSeatingCapacity() {
        return seatingCapacityInEconomyClass + seatingCapacityInBusinessClass;
    }

    public String getPlaneName() {
        return String.valueOf(producer.getPlaneName() + "-" + code);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = planeType.getDescription().hashCode() + getPlaneName().hashCode();
        return prime * (hash + getCommonSeatingCapacity() * operatingSpeed + id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        PassengerJet o = (PassengerJet) obj;

        return this.id == o.id && this.producer == o.producer && this.code.equals(o.code) && this.practicalRange == o.practicalRange
                && this.practicalCapacity == o.practicalCapacity && this.operatingSpeed == o.operatingSpeed
                && this.serviceCeiling == o.serviceCeiling && this.getCommonSeatingCapacity() == o.getCommonSeatingCapacity();
    }

    @Override
    public String toString() {
        return String.format("Passenger Jet [name = \"%s\"; id = %d; operating speed = %d; service ceiling = %d; practical capacity = %.2f; " +
                "practical range = %d; seating capacity = %d]", getPlaneName(), id, operatingSpeed, serviceCeiling, practicalCapacity,
                practicalRange, getCommonSeatingCapacity());
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
