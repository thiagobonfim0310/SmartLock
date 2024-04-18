package com.smartlock.Business.entities;

import java.util.UUID;

public class Lock {

    private UUID id;
    private String numerOfSerie;
    private User user[];
    private Enviroments enviroment;
    private String protocol;

    public void setEnviroment(Enviroments enviroment) {
        this.enviroment = enviroment;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNumerOfSerie(String numerOfSerie) {
        this.numerOfSerie = numerOfSerie;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setUser(User[] user) {
        this.user = user;
    }

    public Enviroments getEnviroment() {
        return enviroment;
    }

    public UUID getId() {
        return id;
    }

    public String getNumerOfSerie() {
        return numerOfSerie;
    }

    public String getProtocol() {
        return protocol;
    }

    public User[] getUser() {
        return user;
    }

}
