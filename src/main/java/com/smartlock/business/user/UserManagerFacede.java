package com.smartlock.business.user;

import com.smartlock.business.entities.User;
import com.smartlock.business.exceptions.EmailNotFoundException;
import com.smartlock.business.validators.ValidateEmail;
import com.smartlock.infra.database.Database;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

//Facade
public class UserManagerFacede {
    private static UserManagerFacede instance;
    private Database data;
    private ValidateEmail validEmail;

    public static UserManagerFacede getInstance(Database database, ValidateEmail validateEmail) {
        if (instance == null) {
            instance = new UserManagerFacede(database, validateEmail);
        }

        return instance;
    }

    public UserManagerFacede(Database database, ValidateEmail validateEmail) {
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

    public void acessUserEnviromentController(UUID idUser, UUID idEnviroment) {
        data.acessUserEnviroment(idUser, idEnviroment);
    }

}
