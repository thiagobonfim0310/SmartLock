package com.smartlock.view.lock;

import java.util.Scanner;

import com.smartlock.view.user.UserPage;

public class LockMenu {
    LockPage lockPage;

    public LockMenu(LockPage lock) {
        lockPage = lock;
    }

    public void menu() {

        int option;
        while (true) {
            System.out.println("Selecione a opção que deseja ");
            System.out.println("[1] - Cadastrar Tranca");
            System.out.println("[2] - Listar Tranca ");
            System.out.println("[3] - Atualizar Tranca ");
            System.out.println("[4] - Deletar Tranca ");
            System.out.println("[5] - Desfazer ultima alteração ");
            System.out.println("[6] - Voltar ");

            Scanner input = new Scanner(System.in);
            option = input.nextInt();
            switch (option) {
                case 1:
                    this.lockPage.registerLockPage();
                    break;
                case 2:
                    this.lockPage.listLockPage();
                    break;
                case 3:
                    this.lockPage.updateLockPage();
                    break;
                case 4:
                    this.lockPage.deleteLockPage();
                    break;
                case 5:
                    this.lockPage.retoreBackupPage();
                    break;
                case 6:
                    return;
                default:
                    break;
            }

        }
    }
}
