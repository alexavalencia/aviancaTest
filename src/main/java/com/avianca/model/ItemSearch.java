package com.avianca.model;

public class ItemSearch {
    private String fromCity;
    private String toCity;
    private String initDate;
    private String endDate;
    private String passengers;

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public String getInitDate() {
        return initDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getPassengers() {
        return passengers;
    }
}
