package com.smartlock.Infra.database;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.smartlock.Business.entities.Admin;
import com.smartlock.Business.entities.Lock;
import com.smartlock.Business.entities.User;

public class Memory implements Database {
    List<User> users = new ArrayList<>();
    List<Admin> admins = new ArrayList<>();
    List<Lock> locks = new ArrayList<>();

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

    public void saveLock(Lock Lock) {
        locks.add(Lock);
    }

    public List<Lock> listLocks() {
        return locks;
    }

    public void updateLock(Lock lock, UUID id) {

        for (Lock loc : locks) {
            if (loc.getId().equals(id)) {
                loc = lock;
            }

        }
    }

    public void deleteLock(UUID id) {

        for (Lock loc : locks) {
            if (loc.getId().equals(id)) {
                locks.remove(loc);
            }

        }
    }

}
