package com.smartlock.view.user;

import java.util.Scanner;

import com.smartlock.business.admin.AdminManager;
import com.smartlock.view.StartUpPage;

//Command
public class LoginCommand implements Command {
    LoginPage loginPage;
    AdminManager managerAdmin;
    StartUpPage menu;
    Scanner input = new Scanner(System.in);
    String email;
    String password;

    public LoginCommand(LoginPage loginPage, AdminManager adminManager, StartUpPage menu) {
        this.loginPage = loginPage;
        managerAdmin = adminManager;
        this.menu = menu;
    }

    public void execute() {
        while (true) {
            loginPage.login();
            System.out.println("Email: ");
            email = input.nextLine().toString();
            System.out.println("Senha:");
            password = input.nextLine().toString();

            if (managerAdmin.autenticaterAdmin(email, password)) {

                this.menu.menu();
            }
            System.out.println("Senha ou email errado \n");
        }
    }
}
