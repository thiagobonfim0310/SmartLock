package com.smartlock.Business.entities;

import java.util.UUID;
import java.util.List;

public class Lock {

    private UUID id;
    private String numberOfSerie;
    private List<User> user;
    private Enviroments enviroment;
    private String protocol;

    public Lock() {

    }

    public Lock(UUID id, String numberOfSerie, Enviroments enviroment, String protocol) {
        this.id = id;
        this.numberOfSerie = numberOfSerie;
        this.enviroment = enviroment;
        this.protocol = protocol;

    }

    public void setEnviroment(Enviroments enviroment) {
        this.enviroment = enviroment;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNumerOfSerie(String numerOfSerie) {
        this.numberOfSerie = numerOfSerie;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Enviroments getEnviroment() {
        return enviroment;
    }

    public UUID getId() {
        return id;
    }

    public String getNumberOfSerie() {
        return numberOfSerie;
    }

    public String getProtocol() {
        return protocol;
    }

    public List<User> getUser() {
        return user;
    }

}
