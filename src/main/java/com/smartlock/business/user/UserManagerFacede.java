package com.smartlock.business.user;

import com.smartlock.business.adapters.Images.ImageAdapter;
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
    private ImageAdapter imgAdapter;

    public static UserManagerFacede getInstance(Database database, ValidateEmail validateEmail, ImageAdapter imgAdapter) {
        if (instance == null) {
            instance = new UserManagerFacede(database, validateEmail, imgAdapter);
        }

        return instance;
    }

    public UserManagerFacede(Database database, ValidateEmail validateEmail, ImageAdapter imgAdapter) {
        this.data = database;
        this.validEmail = validateEmail;
        this.imgAdapter = imgAdapter;
    }

    public void registerUserController(User user, String imagepath) throws EmailNotFoundException {


        if (!validEmail.isValidEmail(user)) {
            throw new EmailNotFoundException();
        }
        user.setId(UUID.randomUUID());
        imgAdapter.processImage(imagepath);
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
