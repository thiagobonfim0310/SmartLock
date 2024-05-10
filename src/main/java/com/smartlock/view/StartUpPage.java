package com.smartlock.view;

import java.util.Scanner;

import com.smartlock.view.enviroment.EnviromentMenu;
import com.smartlock.view.lock.LockMenu;
import com.smartlock.view.user.UserMenu;
import com.smartlock.view.user.UserPage;

//Strategy
public class StartUpPage {
    UserMenu userMenu;
    LockMenu lockMenu;
    EnviromentMenu enviromentMenu;
    ContextStrategyMenu context;

    public StartUpPage(UserMenu user, LockMenu lock, EnviromentMenu enviroment, ContextStrategyMenu context) {
        this.context = context;
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
                    context.setStrategy(userMenu);
                    break;
                case 2:
                    context.setStrategy(enviromentMenu);
                    break;
                case 3:
                    context.setStrategy(lockMenu);
                    break;
                default:
                    context.setStrategy(userMenu);
                    break;
            }

            context.excuteStrategy();

        }
    }
}
