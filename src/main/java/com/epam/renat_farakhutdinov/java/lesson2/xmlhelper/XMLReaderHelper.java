package com.epam.renat_farakhutdinov.java.lesson2.xmlhelper;

import com.epam.renat_farakhutdinov.java.lesson2.exceptions.InvalidPlainCharacteristicException;
import com.epam.renat_farakhutdinov.java.lesson2.planes.Plane;
import com.epam.renat_farakhutdinov.java.lesson2.planes.PlaneBrand;
import com.epam.renat_farakhutdinov.java.lesson2.planes.airfreighters.Airfreighter;
import com.epam.renat_farakhutdinov.java.lesson2.planes.passenger_jets.PassengerJet;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Renat Farakhutdinov on 01.05.2018.
 */
public class XMLReaderHelper {
    public static Plane getNewPlane(String pathname) throws Exception {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(false);
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(pathname));
            document.getDocumentElement().normalize();

            return parseDocument(document);
        } catch (Exception exception) {
            String message = "XML parsing error!";
            throw new Exception(message);
        }
    }

    private static Plane parseDocument(Document doc) throws Exception {
        Node plane = doc.getElementsByTagName("plane").item(0);

        int uid = Integer.parseInt(getUID(plane));
        String type = getType(plane);

        if (plane.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) plane;
            Node parameters = element.getElementsByTagName("parameters").item(0);

            return parseParameters(uid, type, parameters);
        }

        return null;
    }

    private static Plane parseParameters(int UID, String type, Node node) throws InvalidPlainCharacteristicException {
        Element parameters = (Element) node;

        String producer = parameters.getElementsByTagName("producer").item(0).getTextContent();
        PlaneBrand planeBrand = PlaneBrand.getPlaneBrandByPlaneName(producer);

        String code = parameters.getElementsByTagName("code").item(0).getTextContent();
        double practicalCapacity = Double.parseDouble(parameters.getElementsByTagName("practical_capacity").item(0).getTextContent());
        int practicalRange = Integer.parseInt(parameters.getElementsByTagName("practical_range").item(0).getTextContent());
        int operatingSpeed = Integer.parseInt(parameters.getElementsByTagName("operating_speed").item(0).getTextContent());
        int serviceCeiling = Integer.parseInt(parameters.getElementsByTagName("service_ceiling").item(0).getTextContent());

        if ("PassengerJet".equals(type)) {
            int seatingCapacityInEconomyClass = Integer.parseInt(parameters.getElementsByTagName("seating_capacity_in_economy_class").item(0).getTextContent());
            int seatingCapacityInBusinessClass = Integer.parseInt(parameters.getElementsByTagName("seating_capacity_in_business_class").item(0).getTextContent());
            double revenueLoad = Double.parseDouble(parameters.getElementsByTagName("revenue_load").item(0).getTextContent());

            return new PassengerJet(UID, planeBrand, code, practicalCapacity, practicalRange, operatingSpeed,
                    serviceCeiling, seatingCapacityInEconomyClass, seatingCapacityInBusinessClass, revenueLoad);
        }

        if ("Airfreighter".equals(type)) {
            double sizeOfFreightArea = Double.parseDouble(parameters.getElementsByTagName("size_of_freight_area").item(0).getTextContent());
            double activeLoad = Double.parseDouble(parameters.getElementsByTagName("active_load").item(0).getTextContent());

            return new Airfreighter(UID, planeBrand, code, practicalCapacity, practicalRange, operatingSpeed,
                    serviceCeiling, sizeOfFreightArea, activeLoad);
        }

        return null;
    }

    private static String getUID(Node node) {
        Element plane = (Element) node;
        Node uid = plane.getElementsByTagName("UID").item(0);

        return uid.getTextContent();
    }

    private static String getType(Node node) {
        Element plane = (Element) node;
        Node name = plane.getElementsByTagName("type").item(0);

        return name.getTextContent();
    }
}
