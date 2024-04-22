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

    public void registerUserController(User user) throws EmailNotFoundException {

        if (!ValidateUser.validateEmail(user.getEmail())) {
            throw new EmailNotFoundException();
        }
        user.setId(UUID.randomUUID());
        if (user.getType().isEmpty()) {
            List<String> types = new ArrayList<>();
            types.add("Colaborador");
            user.setType(types);

        }
        data.saveUser(user);
    }

    public List<User> listUserController() {
        List<User> users = new ArrayList();

        users = data.getUsers();
        return users;
    }

    public void updateUserController(User user, UUID id) {

        data.updateUsers(user, id);
    }

    public void deleteUserController(UUID id) {
        data.deleteUser(id);
    }

}
