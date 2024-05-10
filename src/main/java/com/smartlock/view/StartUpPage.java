package com.smartlock.view;

import java.util.Scanner;

import com.smartlock.view.enviroment.EnviromentMenu;
import com.smartlock.view.lock.LockMenu;
import com.smartlock.view.reports.ReportMenu;
import com.smartlock.view.reports.ReportPage;
import com.smartlock.view.user.UserMenu;
import com.smartlock.view.user.UserPage;

//Strategy
public class StartUpPage {
    UserMenu userMenu;
    LockMenu lockMenu;
    EnviromentMenu enviromentMenu;
    ContextStrategyMenu context;
    ReportMenu reportMenu;

    public StartUpPage(UserMenu user, LockMenu lock, EnviromentMenu enviroment, ContextStrategyMenu context, ReportMenu report) {
        this.context = context;
        this.userMenu = user;
        this.lockMenu = lock;
        this.enviromentMenu = enviroment;
        this.reportMenu = report;

    }

    public void menu() {

        int option;
        while (true) {
            System.out.println("Selecione a opção que deseja ");
            System.out.println("[1] - Gerencimento de Usuário");
            System.out.println("[2] - Gerencimento Ambientes ");
            System.out.println("[3] - Gerenciamento de Trancas ");
            System.out.println("[4] - Gerenciamento de Relatórios ");

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
                case 4:
                    this.reportMenu.menu();
                    break;

                default:
                    context.setStrategy(userMenu);
                    break;
            }

            context.excuteStrategy();

        }
    }
}
