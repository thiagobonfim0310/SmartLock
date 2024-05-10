package com.smartlock.business.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String email;
    private String cpf;
    private List<String> type;
    private List<Enviroments> perms;

    public User() {
        this.perms = new ArrayList<Enviroments>();
        this.type = new ArrayList<String>();
    }

    public User(String type) {
        this.perms = new ArrayList<Enviroments>();
        List<String> types = new ArrayList<>();
        types.add(type);
        this.type = types;
    }

    public UUID getId() {
        return id;
    }

    public List<Enviroments> getPerms() {
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

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPerms(List<Enviroments> perms) {
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