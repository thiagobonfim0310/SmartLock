package com.smartlock.business.user;

import com.smartlock.business.entities.Student;

public class StudentFactory {
    static public Student criarUsuario() {
        return new Student();
    }
}
