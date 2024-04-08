package com.smartlock.View;

import java.util.Scanner;

import com.smartlock.Business.User.UserManager;
import com.smartlock.View.User.UserPage;

public class StartUpPage {
    UserPage userPage;

    public StartUpPage(UserPage user) {
        userPage = user;
    }

    public void menu() {

        int option;
        while (true) {
            System.out.println("Selecione a opção que deseja ");
            System.out.println("[1] - Cadastrar Usuário");
            System.out.println("[2] - Listar Usuário ");

            Scanner input = new Scanner(System.in);
            option = input.nextInt();
            switch (option) {
                case 1:
                    this.userPage.registerUserPage();
                    break;
                case 2:
                    this.userPage.listUserPage();
                    break;
                default:
                    break;
            }

        }
    }
}
