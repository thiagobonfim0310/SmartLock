package com.smartlock.Business.User;

import com.smartlock.Business.exceptions.EmailNotFoundException;
import com.smartlock.Business.validators.ValidateEmail;
import com.smartlock.Infra.database.Database;
import com.smartlock.Business.entities.User;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class UserManager {

    private Database data;
    private ValidateEmail validEmail;

    public UserManager(Database database, ValidateEmail validateEmail) {
        this.data = database;
        this.validEmail = validateEmail;
    }

    public void registerUserController(User user) throws EmailNotFoundException {

        if (!validEmail.isValidEmail(user.getEmail())) {
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
        List<User> users = new ArrayList<>();

        users = data.listUsers();
        return users;
    }

    public void updateUserController(User user, UUID id) {

        data.updateUsers(user, id);
    }

    public void deleteUserController(UUID id) {
        data.deleteUser(id);
    }

}
