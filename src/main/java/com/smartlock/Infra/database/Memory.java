package com.smartlock.Infra.database;

import java.util.ArrayList;
import java.util.List;

import com.smartlock.Business.entities.User;

public class Memory implements Database {
    List<User> usuarios = new ArrayList<>();

    public void saveUser(User usuario) {
        usuarios.add(usuario);
    }

    public List<User> getUsers() {
        return usuarios;
    }

}
