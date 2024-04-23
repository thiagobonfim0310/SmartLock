package com.smartlock.View.Lock;

import java.util.Scanner;
import com.smartlock.View.User.UserPage;

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
            System.out.println("[5] - Voltar ");

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
                    return;
                default:
                    break;
            }

        }
    }
}
