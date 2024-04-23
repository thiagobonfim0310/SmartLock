package com.smartlock.Business.entities;

import java.util.UUID;
import java.util.List;

public class Enviroments {

    private UUID id;
    private String name;
    private List<Enviroments> enviroments;
    private List<Lock> locks;
    
    public List<Enviroments> getEnviroments() {
        return enviroments;
    }

    public UUID getId() {
        return id;
    }

    public List<Lock> getLocks() {
        return locks;
    }

    public String getName() {
        return name;
    }

    public void setEnviroments(List<Enviroments> enviroments) {
        this.enviroments = enviroments;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setLocks(List<Lock> locks) {
        this.locks = locks;
    }

    public void setName(String name) {
        this.name = name;
    }
}
