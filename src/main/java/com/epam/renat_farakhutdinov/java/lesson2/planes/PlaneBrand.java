package com.epam.renat_farakhutdinov.java.lesson2.planes;

/**
 * Created by Renat Farakhutdinov on 24.02.2018.
 */
public enum PlaneBrand {
    ATP("ATP", "Aerospatiale/Alenia", "Italy"),
    AIRBUS("Airbus", "Airbus S.A.S.", "EU"),
    BOEING("Boeing", "Boeing Commercial Airplanes", "USA"),
    BELL("Bell", "Bell/Agusta Aerospace Company", "USA"),
    BOMBARDIER("Bombardier", "Bombardier Aerospace", "Canada"),
    BRITISH("British", "British Aerospace", "UK"),
    CONCORDE("Concorde", "BAC-SNIAS", "France"),
    SUPERJET("Superjet", "Гражданские самолеты Сухого", "Russia"),
    TU("Ту", "ОКБ А.Н.Туполева", "Russia"),
    YAK("Як", "ОКБ А.С. Яковлева", "Russia"),
    AN("Ан", "ОКБ О.К.Антонова", "Russia/Ukraine");

    private String planeName, producer, country;

    PlaneBrand(String planeName, String producer, String country) {
        this.planeName = planeName;
        this.producer = producer;
        this.country = country;
    }

    public String getPlaneName() {
        return planeName;
    }

    public String getProducer() {
        return producer;
    }

    public String getCountry() {
        return country;
    }
}
