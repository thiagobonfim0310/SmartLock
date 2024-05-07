package com.smartlock.view;

import java.util.Scanner;

import com.smartlock.business.user.UserManager;
import com.smartlock.view.enviroment.EnviromentMenu;
import com.smartlock.view.lock.LockMenu;
import com.smartlock.view.user.UserMenu;
import com.smartlock.view.user.UserPage;

public class StartUpPage {
    UserMenu userMenu;
    LockMenu lockMenu;
    EnviromentMenu enviromentMenu;

    public StartUpPage(UserMenu user, LockMenu lock, EnviromentMenu enviroment) {

        this.userMenu = user;
        this.lockMenu = lock;
        this.enviromentMenu = enviroment;

    }

    public void menu() {

        int option;
        while (true) {
            System.out.println("Selecione a opção que deseja ");
            System.out.println("[1] - Gerencimento de Usuário");
            System.out.println("[2] - Gerencimento Ambientes ");
            System.out.println("[3] - Gerenciamento de Trancas ");

            Scanner input = new Scanner(System.in);
            option = input.nextInt();
            switch (option) {
                case 1:
                    this.userMenu.menu();
                    break;
                case 2:
                    this.enviromentMenu.menu();
                    break;
                case 3:
                    this.lockMenu.menu();
                    break;

                default:
                    break;
            }

        }
    }
}
