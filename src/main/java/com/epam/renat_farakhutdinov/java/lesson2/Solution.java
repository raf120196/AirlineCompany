package com.epam.renat_farakhutdinov.java.lesson2;

import com.epam.renat_farakhutdinov.java.lesson2.companies.AirlineCompany;
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

        Plane boeing747 = new PassengerJet(1, PlaneBrand.BOEING, "747", 333400, 14205, 988, 13700, 490, 452, 76800);
        Plane airbusA380 = new PassengerJet(2, PlaneBrand.AIRBUS, "A380", 560000, 15000, 1020, 13100, 700, 525, 83100);
        Plane superjetSSJ95 = new PassengerJet(3, PlaneBrand.SUPERJET, "SSJ-95", 42500, 3050, 860, 12200, 98, 0, 12250);
        Plane tu154 = new PassengerJet(4, PlaneBrand.TU, "154", 98000, 2780, 950, 12100, 164, 131, 18000);
        Plane yak42 = new PassengerJet(5, PlaneBrand.YAK, "42", 57000, 4000, 700, 9600, 120, 104, 13500);
        Plane boeing777 = new PassengerJet(6, PlaneBrand.BOEING, "777", 263080, 7500, 945, 13100, 550, 479, 66050);

        Plane an12 = new Airfreighter(7, PlaneBrand.AN, "12", 61100, 6200, 780, 10200, 330, 17000);
        Plane an225 = new Airfreighter(8, PlaneBrand.AN, "225", 640000, 15400, 850, 12000, 5400, 250000);
        Plane tu330 = new Airfreighter(9, PlaneBrand.TU, "330", 112000, 7000, 825, 11000, 3200, 35000);
        Plane an12_1 = new Airfreighter(10, PlaneBrand.AN, "12", 61100, 6200, 780, 10200, 330, 17000);
        Plane an225_1 = new Airfreighter(11, PlaneBrand.AN, "225", 640000, 15400, 850, 12000, 5400, 250000);
        Plane tu330_1 = new Airfreighter(12, PlaneBrand.TU, "330", 112000, 7000, 825, 11000, 3200, 35000);

        myCompany.addPlane(boeing747);
        myCompany.addPlane(airbusA380);
        myCompany.addPlane(superjetSSJ95);
        myCompany.addPlane(tu154);
        myCompany.addPlane(yak42);
        myCompany.addPlane(boeing777);
        myCompany.addPlane(an12);
        myCompany.addPlane(an225);
        myCompany.addPlane(tu330);
        myCompany.addPlane(an12_1);
        myCompany.addPlane(an225_1);
        myCompany.addPlane(tu330_1);

        System.out.println("\nList of planes of the airline company: ");
        for (Plane plane : myCompany.getPark()) {
            System.out.println(plane.toString());
        }

        System.out.println("\nFull capability: " + myCompany.getFullCapacity());
        System.out.println("Full seating capability: " + myCompany.getFullSeatingCapacity());
    }
}
