package com.epam.renat_farakhutdinov.java.lesson2.serialisation;

import com.epam.renat_farakhutdinov.java.lesson2.companies.AirlineCompany;
import com.epam.renat_farakhutdinov.java.lesson2.planes.airfreighters.Airfreighter;
import com.epam.renat_farakhutdinov.java.lesson2.planes.passenger_jets.PassengerJet;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;

/**
 * Created by Renat Farakhutdinov on 26.04.2018.
 */
public class SerializationHelper {
    private static SerializationHelper currentInstance = new SerializationHelper();

    public static SerializationHelper getInstance() {
        return currentInstance;
    }

    private SerializationHelper() {
    }

    public boolean serializeAirlineCompany(final AirlineCompany airlineCompany, String nameOfFile) {
        XStream xs = new XStream();
        xs.alias("airfreighter", Airfreighter.class);
        xs.alias("passenger_jet", PassengerJet.class);
        xs.alias("airline_company", AirlineCompany.class);

        try {
            FileOutputStream fs = new FileOutputStream(nameOfFile);
            xs.toXML(airlineCompany, fs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        System.out.println("AirlineCompany has been serialized to " + nameOfFile);
        return true;
    }

    public boolean deserializeAirlineCompany(String nameOfFile) {
        XStream xs = new XStream(new DomDriver());
        xs.alias("airfreighter", Airfreighter.class);
        xs.alias("passenger_jet", PassengerJet.class);
        xs.alias("airline_company", AirlineCompany.class);

        AirlineCompany airlineCompany = new AirlineCompany();
        try {
            FileInputStream fis = new FileInputStream(nameOfFile);
            xs.fromXML(fis, airlineCompany);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        System.out.println("Deserialized airline company: \n" + airlineCompany.toString());
        return true;
    }
}
