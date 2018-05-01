package com.epam.renat_farakhutdinov.java.lesson2.planes;

/**
 * Created by Renat Farakhutdinov on 24.02.2018.
 */
public interface Plane extends Comparable<Plane> {
    public PlaneBrand getBrand();

    public String getCode();

    public int getID();

    public PlaneType getType();

    public double getPracticalCapacity(); // практическая грузоподъемность

    public int getPracticalRange(); // практическая дальность полета

    public int getOperatingSpeed(); // крейсерская скорость

    public int getServiceCeiling(); // практический потолок
}
