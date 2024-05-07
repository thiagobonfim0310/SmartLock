package com.smartlock.business.user;

import com.smartlock.business.entities.User;

public class UserFactory {

    static public User criarUsuario(String type) {
        switch (type) {
            case "professor":
                return TeacherFactory.criarUsuario();
            case "aluno":
                return StudentFactory.criarUsuario();
            default:
                return new User();
        }

    }

}
