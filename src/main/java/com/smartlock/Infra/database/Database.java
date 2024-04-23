package com.smartlock.Infra.database;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.smartlock.Business.entities.Admin;
import com.smartlock.Business.entities.User;

public interface Database {

    public void saveUser(User usuario);

    public List<User> getUsers();

    public void updateUsers(User user, UUID id);

    public void deleteUser(UUID id);

    public boolean autenticarAdmin(String email, String password);
}