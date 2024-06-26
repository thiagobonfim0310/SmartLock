package com.smartlock.infra.database;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.smartlock.business.entities.Admin;
import com.smartlock.business.entities.Enviroments;
import com.smartlock.business.entities.Lock;
import com.smartlock.business.entities.User;;

public interface Database {

    public void saveUser(User usuario);

    public List<User> listUsers();

    public void updateUsers(User user, UUID id);

    public void deleteUser(UUID id);

    public void acessUserEnviroment(UUID idUser, UUID idEnviroment);

    public boolean autenticarAdmin(String email, String password);

    public void saveLock(Lock Lock);

    public List<Lock> listLocks();

    public void updateLock(Lock lock, UUID id);

    public void deleteLock(UUID id);

    public void saveEnviroment(Enviroments enviroment);

    public List<Enviroments> listEnviroments();

    public void updateEnviroments(Enviroments enviroment, UUID id);

    public void deleteEnviroments(UUID id);
}