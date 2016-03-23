package jmp.module16.entities;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeAddress {

    private String city;

    private String street;

    public EmployeeAddress() {}

    public EmployeeAddress(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "EmployeeAddress { city = " + city +", street = " + street + "}";
    }

}