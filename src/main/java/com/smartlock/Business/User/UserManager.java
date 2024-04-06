package com.smartlock.Business.User;

import com.smartlock.Business.entities.User;
import com.smartlock.Infra.Database;

public class UserManager {
    static Database data = new Database();

    public static void registerUserController(User usuario) {

        data.saveUser(usuario);
    }

}
