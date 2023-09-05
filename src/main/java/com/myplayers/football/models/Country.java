package com.myplayers.football.models;

public enum Country {
    SPAIN("Spain"),
    FRANCE("France"),
    GERMANY("Germany"),
    ITALY("Italy"),
    ENGLAND("England");

    private final String countryName;

    Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
