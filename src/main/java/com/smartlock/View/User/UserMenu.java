package com.smartlock.View.User;

import java.util.Scanner;

public class UserMenu {
    UserPage userPage;

    public UserMenu(UserPage user) {
        userPage = user;
    }

    public void menu() {

        int option;
        while (true) {
            System.out.println("Selecione a opção que deseja ");
            System.out.println("[1] - Cadastrar Usuário");
            System.out.println("[2] - Listar Usuário ");
            System.out.println("[3] - Atualizar Usuário ");
            System.out.println("[4] - Deletar Usuário ");
            System.out.println("[5] - Dar acesso a Ambiente ");
            System.out.println("[6] - Voltar ");
            Scanner input = new Scanner(System.in);
            option = input.nextInt();
            switch (option) {
                case 1:
                    this.userPage.registerUserPage();
                    break;
                case 2:
                    this.userPage.listUserPage();
                    break;
                case 3:
                    this.userPage.updateUserPage();
                    break;
                case 4:
                    this.userPage.deleteUserPage();
                    break;
                case 5:
                    this.userPage.acessUserEnviromentPage();
                    break;
                case 6:
                    return;
                default:
                    break;
            }

        }
    }
}