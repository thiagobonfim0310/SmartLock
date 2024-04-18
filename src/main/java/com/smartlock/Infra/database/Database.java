package com.smartlock.Infra.database;

import java.util.ArrayList;
import java.util.List;

import com.smartlock.Business.entities.User;

public interface Database {

    public void saveUser(User usuario);

    public List<User> getUsers();
}