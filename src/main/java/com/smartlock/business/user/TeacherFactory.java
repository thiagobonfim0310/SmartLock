package com.smartlock.business.user;

import com.smartlock.business.entities.Teacher;
import com.smartlock.business.entities.User;

public class TeacherFactory extends UserFactory {

    static public User criarUsuario() {
        return new Teacher();
    }

}
