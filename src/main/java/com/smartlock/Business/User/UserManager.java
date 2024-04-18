package com.smartlock.Business.User;

import com.smartlock.Business.exceptions.EmailNotFoundException;
import com.smartlock.Business.validators.ValidateUser;
import com.smartlock.Infra.database.Database;
import com.smartlock.Business.entities.User;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class UserManager {

    Database data;

    public UserManager(Database database) {
        data = database;
    }

    public void registerUserController(User usuario) throws EmailNotFoundException {

        if (!ValidateUser.validateEmail(usuario.getEmail())) {
            throw new EmailNotFoundException();
        }
        usuario.setId(UUID.randomUUID());
        data.saveUser(usuario);
    }

    public List<User> listUserController() {
        List<User> users = new ArrayList();

        users = data.getUsers();
        return users;
    }

}
