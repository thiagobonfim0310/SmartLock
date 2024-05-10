package com.smartlock.business.entities;

import java.util.UUID;

abstract class EnviromentsPrototype {
    private UUID id;

    public EnviromentsPrototype() {
    }

    public EnviromentsPrototype(EnviromentsPrototype enviroment) {
        if (enviroment != null) {
            this.id = enviroment.getId();
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    abstract public EnviromentsPrototype clone();
}
