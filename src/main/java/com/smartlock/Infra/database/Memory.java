package com.smartlock.Infra.database;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.smartlock.Business.entities.Admin;
import com.smartlock.Business.entities.User;

public class Memory implements Database {
    List<User> users = new ArrayList<>();
    List<Admin> admins = new ArrayList<>();

    public Memory() {
        Admin adm = new Admin();
        adm.setEmail("admin@admin.com");
        adm.setId(UUID.randomUUID());
        adm.setName("admin");
        adm.setPassword("admin");
        admins.add(adm);
    }

    public boolean autenticarAdmin(String email, String password) {

        for (Admin adm : admins) {
            if (adm.getEmail() == email && adm.getPassword() == password) {
                return true;
            }
        }

        return false;
    }

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
