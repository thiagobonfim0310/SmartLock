package com.smartlock.Infra.database;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.smartlock.Business.entities.Admin;
import com.smartlock.Business.entities.User;
import com.smartlock.Business.entities.Enviroments;;

public interface Database {

    public void saveUser(User usuario);

    public List<User> getUsers();

    public void updateUsers(User user, UUID id);

    public void deleteUser(UUID id);

    public boolean autenticarAdmin(String email, String password);


    public void saveEnviroment(Enviroments enviroment);

    public List<Enviroments> getEnviroments();

    public void updateEnviroments(Enviroments enviroment, UUID id);

    public void deleteEnviroments(UUID id);
}