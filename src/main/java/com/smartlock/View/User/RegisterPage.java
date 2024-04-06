package com.smartlock.View.User;

import java.util.Scanner;

import com.smartlock.Business.User.UserManager;
import com.smartlock.Business.entities.User;

public class RegisterPage {
    public static void registerUser() {
        User user = new User();
        Scanner input = new Scanner(System.in);

        System.out.println("Comece o cadastro :");
        System.out.println("Cadastrar Usuario \n");
        System.out.print("Nome: \n");
        user.setName(input.nextLine());
        System.out.print("Email: \n");
        user.setEmail(input.nextLine());
        System.out.print("Cpf: \n");
        user.setCpf(input.nextLine());
        System.out.print("Número: \n");
        user.setNumber(input.nextLine());
        // TO-DO : Adicionar o cadastro de tipo
        UserManager.registerUserController(user);
        System.out.print("------------------Cadastro Finalizado------------------ \n");

    }

}
