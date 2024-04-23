package com.smartlock.Business.Admin;

import com.smartlock.Infra.database.Database;

public class AdminManager {

    Database data;

    public AdminManager(Database database) {
        data = database;
    }

    public boolean autenticaterAdmin(String email, String password) {

        if (data.autenticarAdmin(email, password)) {
            return true;
        }
        return false;
    }
}