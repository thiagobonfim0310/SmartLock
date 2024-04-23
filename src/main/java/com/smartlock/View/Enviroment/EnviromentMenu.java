package com.smartlock.View.Enviroment;

import java.util.Scanner;

public class EnviromentMenu {
    EnviromentPage enviromentPage;

    public EnviromentMenu(EnviromentPage enviroment) {
        enviromentPage = enviroment;
    }

    public void menu() {

        int option;
        while (true) {
            System.out.println("Selecione a opção que deseja ");
            System.out.println("[1] - Cadastrar Ambiente");
            System.out.println("[2] - Listar Ambiente ");
            System.out.println("[3] - Atualizar Ambiente ");
            System.out.println("[4] - Deletar Ambiente ");
            System.out.println("[5] - Voltar ");
            Scanner input = new Scanner(System.in);
            option = input.nextInt();
            switch (option) {
                case 1:
                    this.enviromentPage.registerEnviromentPage();
                    break;
                case 2:
                    this.enviromentPage.listEnviromentPage();
                    break;
                case 3:
                    this.enviromentPage.updateEnviromentPage();
                    break;
                case 4:
                    this.enviromentPage.deleteEnviromentPage();
                    break;
                case 5:
                    return;
                default:
                    break;
            }

        }
    }
}
