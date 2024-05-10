package com.smartlock.business.entities;

import java.util.UUID;
import java.util.List;

public class Enviroments extends EnviromentsPrototype {

    private String name;
    private List<Enviroments> enviroments;
    private List<Lock> locks;

    public Enviroments() {

    }

    public Enviroments(Enviroments enviroments) {
        super(enviroments);
    }

    public List<Enviroments> getEnviroments() {
        return enviroments;
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

    public void setLocks(List<Lock> locks) {
        this.locks = locks;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public EnviromentsPrototype clone() {
        return new Enviroments(this);
    }
}
