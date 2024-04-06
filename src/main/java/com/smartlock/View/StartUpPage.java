package com.smartlock.View;

import java.util.Scanner;

import com.smartlock.Business.User.UserManager;

public class StartUpPage {

    public void menu() {

        UserManager User = new UserManager();

        int option;
        while (true) {
            System.out.println("Selecione a opção que deseja ");
            System.out.println("[1] - Cadastrar Usuário");
            System.out.println("[2] - Listar Usuário ");

            Scanner input = new Scanner(System.in);
            option = input.nextInt();
            switch (option) {
                case 1:
                    User.registerUser();
                    break;
                case 2:
                    User.listUsers();
                    break;
                default:
                    break;
            }

        }
    }
}
