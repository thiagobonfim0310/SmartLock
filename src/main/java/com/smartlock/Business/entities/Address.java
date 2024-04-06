package com.smartlock.Business.entities;

public class Address {
    private String cep;
    private String country;
    private String province;
    private String city;
    private String street;
    private int number;

    public String getCep() {
        return cep;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public int getNumber() {
        return number;
    }

    public String getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
