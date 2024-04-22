package com.smartlock.Infra.database;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.smartlock.Business.entities.User;

public class Memory implements Database {
    List<User> users = new ArrayList<>();

    public void saveUser(User usuario) {
        users.add(usuario);
    }

    public List<User> getUsers() {
        return users;
    }

    public void updateUsers(User user, UUID id) {

        for (User use : users) {
            if (use.getId().equals(id)) {
                use = user;
            }

        }
    }

    public void deleteUser(UUID id) {

        for (User use : users) {
            if (use.getId().equals(id)) {
                users.remove(use);
            }

        }
    }

}
