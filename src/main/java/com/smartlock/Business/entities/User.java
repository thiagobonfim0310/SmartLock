package com.smartlock.Business.entities;

public class User {

    private String id;
    private String name;
    private String email;
    private String cpf;
    private String type[];
    private String number;

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String type[]) {
        this.type = type;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}