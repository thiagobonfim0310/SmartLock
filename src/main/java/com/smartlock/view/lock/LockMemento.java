package com.smartlock.view.lock;

import com.smartlock.business.entities.Enviroments;
import com.smartlock.business.entities.Lock;
import com.smartlock.business.lock.Memento;

// Memento
public class LockMemento implements Memento {

    private Lock lock;

    private String numberOfSerie;

    private Enviroments enviroment;
    private String protocol;

    public void setNumberOfSerie(String numberOfSerie) {
        this.numberOfSerie = numberOfSerie;
    }

    public Enviroments getEnviroment() {
        return enviroment;
    }

    public Lock getLock() {
        return lock;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setEnviroment(Enviroments enviroment) {
        this.enviroment = enviroment;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public String getNumberOfSerie() {
        return numberOfSerie;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public LockMemento(Lock lock, String numberOfSerie, Enviroments enviroment, String protocol) {
        this.lock = lock;
        this.enviroment = enviroment;
        this.numberOfSerie = numberOfSerie;
        this.protocol = protocol;

    }

    public void retore() {
        this.lock.setEnviroment(enviroment);
        this.lock.setProtocol(protocol);
        this.lock.setNumerOfSerie(numberOfSerie);
    }

}
