package com.epam.renat_farakhutdinov.java.lesson2;

import com.epam.renat_farakhutdinov.java.lesson2.companies.AirlineCompany;
import com.epam.renat_farakhutdinov.java.lesson2.exceptions.InvalidPlainCharacteristicException;
import com.epam.renat_farakhutdinov.java.lesson2.exceptions.PlainIsNotExistException;
import com.epam.renat_farakhutdinov.java.lesson2.exceptions.PlaneAlreadyExistException;
import com.epam.renat_farakhutdinov.java.lesson2.planes.Plane;
import com.epam.renat_farakhutdinov.java.lesson2.planes.PlaneBrand;
import com.epam.renat_farakhutdinov.java.lesson2.planes.airfreighters.Airfreighter;
import com.epam.renat_farakhutdinov.java.lesson2.planes.passenger_jets.PassengerJet;

/**
 * Created by Renat Farakhutdinov on 25.02.2018.
 */
public class Solution {
    public static void main(String[] args) {
        AirlineCompany myCompany = new AirlineCompany();

        Plane boeing747 = createPassengerJet(1, PlaneBrand.BOEING, "747", 333400, 14205, 988, 13700, 490, 452, 76800);
        Plane airbusA380 = createPassengerJet(2, PlaneBrand.AIRBUS, "A380", 560000, 15000, 1020, 13100, 700, 525, 83100);
        Plane superjetSSJ95 = createPassengerJet(3, PlaneBrand.SUPERJET, "SSJ-95", 42500, 3050, 860, 12200, 98, 0, 12250);
        Plane tu154 = createPassengerJet(4, PlaneBrand.TU, "154", 98000, 2780, 950, 12100, 164, 131, 18000);
        Plane yak42 = createPassengerJet(5, PlaneBrand.YAK, "42", 57000, 4000, 700, 9600, 120, 104, 13500);
        Plane boeing777 = createPassengerJet(6, PlaneBrand.BOEING, "777", 263080, 7500, 945, 13100, 550, 479, 66050);

        Plane an12 = createAirfreighter(7, PlaneBrand.AN, "12", 61100, 6200, 780, 10200, 330, 17000);
        Plane an225 = createAirfreighter(8, PlaneBrand.AN, "225", 640000, 15400, 850, 12000, 5400, 250000);
        Plane tu330 = createAirfreighter(9, PlaneBrand.TU, "330", 112000, 7000, 825, 11000, 3200, 35000);
        Plane an12_1 = createAirfreighter(10, PlaneBrand.AN, "12", 61100, 6200, 780, 10200, 330, 17000);
        Plane an225_1 = createAirfreighter(11, PlaneBrand.AN, "225", 640000, 15400, 850, 12000, 5400, 250000);
        Plane tu330_1 = createAirfreighter(9, PlaneBrand.TU, "330", 112000, 7000, 825, 11000, 3200, 35000);
        Plane tu330_2 = createAirfreighter(156, PlaneBrand.TU, "330", 1120000, 7000, 825, 11000, 3200, 35000);

        addPlaneToCompany(myCompany, boeing747);
        addPlaneToCompany(myCompany, airbusA380);
        addPlaneToCompany(myCompany, superjetSSJ95);
        addPlaneToCompany(myCompany, tu154);
        addPlaneToCompany(myCompany, yak42);
        addPlaneToCompany(myCompany, boeing777);
        addPlaneToCompany(myCompany, an12);
        addPlaneToCompany(myCompany, an225);
        addPlaneToCompany(myCompany, tu330);
        addPlaneToCompany(myCompany, an12_1);
        addPlaneToCompany(myCompany, an225_1);
        addPlaneToCompany(myCompany, tu330_1);

        System.out.println("\nList of planes of the airline company: ");
        for (Plane plane : myCompany.getPark()) {
            System.out.println(plane.toString());
        }

        try {
            myCompany.removePlane(tu330_2);
        } catch (PlainIsNotExistException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nFull capability: " + myCompany.getFullCapacity());
        System.out.println("Full seating capability: " + myCompany.getFullSeatingCapacity());
    }

    public static PassengerJet createPassengerJet(int id, PlaneBrand producer, String code, double practicalCapacity, int practicalRange
            , int operatingSpeed, int serviceCeiling, int seatingCapacityInEconomyClass
            , int seatingCapacityInBusinessClass, double revenueLoad) {

        try {
            return new PassengerJet(id, producer, code, practicalCapacity, practicalRange, operatingSpeed, serviceCeiling,
                    seatingCapacityInEconomyClass, seatingCapacityInBusinessClass, revenueLoad);
        } catch (InvalidPlainCharacteristicException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static Airfreighter createAirfreighter(int id, PlaneBrand producer, String code, double practicalCapacity, int practicalRange
            , int operatingSpeed, int serviceCeiling, double sizeOfFreightArea, double activeLoad) {

        try {
            return new Airfreighter(id, producer, code, practicalCapacity, practicalRange, operatingSpeed, serviceCeiling,
                    sizeOfFreightArea, activeLoad);
        } catch (InvalidPlainCharacteristicException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void addPlaneToCompany(AirlineCompany myCompany, Plane plane) {
        try {
            myCompany.addPlane(plane);
        } catch (PlaneAlreadyExistException e) {
            System.out.println(e.getMessage());
        }
    }
}
