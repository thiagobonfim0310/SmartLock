package com.smartlock.Business.entities;

import java.util.UUID;

public class User {

    public User() {
        this.perms = new Enviroments[0];
        this.type = new String[0];
    }

    private UUID id;
    private String name;
    private String email;
    private String cpf;
    private String type[];
    private Enviroments perms[];

    public UUID getId() {
        return id;
    }

    public Enviroments[] getPerms() {
        return perms;
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

    public void setPerms(Enviroments[] perms) {
        this.perms = perms;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}