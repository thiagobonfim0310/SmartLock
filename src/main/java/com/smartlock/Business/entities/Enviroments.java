package com.smartlock.Business.entities;

import java.util.UUID;

public class Enviroments {

    private UUID id;
    private String name;
    private Enviroments enviroments[];
    private Lock locks[];

    public void setEnviroments(Enviroments enviroments[]) {
        this.enviroments = enviroments;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setLocks(Lock[] locks) {
        this.locks = locks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enviroments[] getEnviroments() {
        return enviroments;
    }

    public UUID getId() {
        return id;
    }

    public Lock[] getLocks() {
        return locks;
    }

    public String getName() {
        return name;
    }
}
