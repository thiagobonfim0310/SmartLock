package com.smartlock.View;

import java.util.Scanner;

import com.smartlock.Business.Admin.AdminManager;

public class LoginPage {

    AdminManager managerAdmin;
    StartUpPage menu;

    public LoginPage(AdminManager adminManager, StartUpPage menu) {
        managerAdmin = adminManager;
        this.menu = menu;
    }

    public void login() {

        Scanner input = new Scanner(System.in);
        String email;
        String password;
        while (true) {
            /*
             * System.out.println("---------- Login ----------");
             * System.out.println("Email: ");
             * email = input.nextLine().toString();
             * System.out.println("Senha:");
             * password = input.nextLine().toString();
             * 
             * if (managerAdmin.autenticaterAdmin(email, password)) {
             */
            this.menu.menu();
            // }
            System.out.println("Senha ou email errado \n");
        }
    }
}
