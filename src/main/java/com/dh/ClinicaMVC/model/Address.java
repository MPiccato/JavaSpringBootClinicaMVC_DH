package com.dh.ClinicaMVC.model;

public class Address {

    private Integer id;
    private String street;
    private Integer numberStreet;
    private String location;
    private String province;

    public Address() {
    }

    public Address(Integer id, String street, Integer numberStreet, String location, String province) {
        this.id = id;
        this.street = street;
        this.numberStreet = numberStreet;
        this.location = location;
        this.province = province;
    }

    public Address(String street, Integer numberStreet, String location, String province) {
        this.street = street;
        this.numberStreet = numberStreet;
        this.location = location;
        this.province = province;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumberStreet() {
        return numberStreet;
    }

    public void setNumberStreet(Integer numberStreet) {
        this.numberStreet = numberStreet;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
