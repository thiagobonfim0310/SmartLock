package com.smartlock.View;

import java.util.Scanner;

import com.smartlock.Business.User.UserManager;
import com.smartlock.View.Enviroment.EnviromentMenu;
import com.smartlock.View.Lock.LockMenu;
import com.smartlock.View.User.UserMenu;
import com.smartlock.View.User.UserPage;

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
