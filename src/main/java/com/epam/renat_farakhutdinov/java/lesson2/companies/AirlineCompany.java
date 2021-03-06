package com.epam.renat_farakhutdinov.java.lesson2.companies;

import com.epam.renat_farakhutdinov.java.lesson2.exceptions.PlainIsNotExistException;
import com.epam.renat_farakhutdinov.java.lesson2.exceptions.PlaneAlreadyExistException;
import com.epam.renat_farakhutdinov.java.lesson2.planes.Plane;
import com.epam.renat_farakhutdinov.java.lesson2.planes.passenger_jets.PassengerJet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Renat Farakhutdinov on 25.02.2018.
 */
public class AirlineCompany {
    private Set<Plane> airpark = new HashSet<>();

    public AirlineCompany() {
        this.airpark = new HashSet<Plane>();
    }

    public Set<Plane> getAirpark() {
        return airpark;
    }

    public void setAirpark(Set<Plane> airpark) {
        this.airpark = airpark;
    }

    public void addPlane(Plane plane) throws PlaneAlreadyExistException {
        if (plane == null || getPlaneById(plane.getID()) != null) {
            throw new PlaneAlreadyExistException("Plane is null or already exist in company!");
        } else {
            airpark.add(plane);
        }
    }

    public void removePlane(Plane plane) throws PlainIsNotExistException {
        if (plane == null || getPlaneById(plane.getID()) == null) {
            throw new PlainIsNotExistException("Plane is null or isn't exist in company!");
        } else {
            airpark.remove(plane);
        }
    }

    public Set<Plane> getPark() {
        return airpark;
    }

    public double getFullCapacity() {
        double sum = 0.0;

        for (Plane plane : airpark) {
            sum += plane.getPracticalCapacity();
        }

        return sum;
    }

    public int getFullSeatingCapacity() {
        int sum = 0;

        for (Plane plane : airpark) {
            if (plane instanceof PassengerJet) {
                sum += ((PassengerJet) plane).getCommonSeatingCapacity();
            }
        }

        return sum;
    }

    public Set<Plane> getPlanesByCapacity(double lowerBound, double upperBound) {
        Set<Plane> result = new HashSet<Plane>();

        for (Plane plane : airpark) {
            if (plane.getPracticalRange() >= lowerBound && plane.getPracticalRange() <= upperBound) {
                result.add(plane);
            }
        }

        return result;
    }

    public Set<Plane> getPlanesBySpeed(double lowerBound, double upperBound) {
        Set<Plane> result = new HashSet<Plane>();

        for (Plane plane : airpark) {
            if (plane.getOperatingSpeed() >= lowerBound && plane.getOperatingSpeed() <= upperBound) {
                result.add(plane);
            }
        }

        return result;
    }

    public Set<Plane> getPlanesByRange(double lowerBound, double upperBound) {
        Set<Plane> result = new HashSet<Plane>();

        for (Plane plane : airpark) {
            if (plane.getPracticalRange() >= lowerBound && plane.getPracticalRange() <= upperBound) {
                result.add(plane);
            }
        }

        return result;
    }

    public Plane getPlaneById(int id) {
        for (Plane plane : airpark) {
            if (plane.getID() == id) {
                return plane;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "AirlineCompany {" + "airpark=" + airpark + '}';
    }
}
