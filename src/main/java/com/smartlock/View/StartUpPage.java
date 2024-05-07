package com.smartlock.View;

import java.util.Scanner;

import com.smartlock.Business.User.UserManager;
import com.smartlock.View.Enviroment.EnviromentMenu;
import com.smartlock.View.Lock.LockMenu;
import com.smartlock.View.User.UserMenu;
import com.smartlock.View.User.UserPage;
import com.smartlock.View.Reports.ReportMenu;
import com.smartlock.View.Reports.ReportPage;

public class StartUpPage {
    UserMenu userMenu;
    LockMenu lockMenu;
    EnviromentMenu enviromentMenu;
    ReportMenu reportMenu;

    public StartUpPage(UserMenu user, LockMenu lock, EnviromentMenu enviroment, ReportMenu report) {

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
                    this.userMenu.menu();
                    break;
                case 2:
                    this.enviromentMenu.menu();
                    break;
                case 3:
                    this.lockMenu.menu();
                    break;
                case 4:
                    this.reportMenu.menu();
                    break;

                default:
                    break;
            }

        }
    }
}
