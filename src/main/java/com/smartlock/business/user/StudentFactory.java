package com.smartlock.business.user;

import com.smartlock.business.entities.Student;
import com.smartlock.business.entities.User;

public class StudentFactory extends UserFactory {
    static public User criarUsuario() {
        return new Student();
    }
}
