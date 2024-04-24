package com.smartlock.Business.User;

import com.smartlock.Business.entities.Student;
import com.smartlock.Business.entities.Teacher;
import com.smartlock.Business.entities.User;

public class UserFactory {

    static public User criarUsuario(String type) {
        switch (type) {
            case "professor":
                return new Teacher();
            case "aluno":
                return new Student();
            default:
                return new User();
        }

    }
}
