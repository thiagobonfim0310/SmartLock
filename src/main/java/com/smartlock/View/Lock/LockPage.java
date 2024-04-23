package com.smartlock.View.Lock;

import java.util.List;
import java.util.Scanner;

import org.sqlite.date.ExceptionUtils;

import com.smartlock.Business.Lock.LockManager;
import com.smartlock.Business.User.UserManager;
import com.smartlock.Business.entities.Lock;
import com.smartlock.Business.entities.User;
import com.smartlock.Business.exceptions.EmailNotFoundException;
import com.smartlock.View.util.PrintEntities;
import com.smartlock.Business.entities.Lock;;

public class LockPage {
    LockManager managerLock;
    PrintEntities print = new PrintEntities();

    public LockPage(LockManager lockManager) {
        managerLock = lockManager;
    }

    public void registerLockPage() {
        Lock lock = new Lock();
        Scanner input = new Scanner(System.in);

        System.out.println("Comece o cadastro :");
        System.out.println("Cadastrar Tranca \n");
        System.out.print("Número de Série: \n");
        lock.setNumerOfSerie(input.nextLine());
        System.out.print("Protocolo: \n");
        lock.setProtocol(input.nextLine());
        // TO-DO : Adicionar o cadastro de tipo
        try {
            managerLock.registerLockController(lock);
        } catch (Exception e) {
            System.out.println("Cadastro inválido");
        }
        System.out.print("------------------Cadastro Finalizado------------------ \n");

    }

    public void listUserPage() {
        List<Lock> locks = managerLock.listLockController();

        for (Lock lock : locks) {
            System.out.print("------------------------------------ \n");
            print.printClass(lock);
            System.out.print("\n");
        }
    }

    public void updateUserPage() {
        Scanner input = new Scanner(System.in);
        List<Lock> locks = managerLock.listLockController();

        int indice = 0;

        System.out.println("Digite o indice do User que dejesa atualizar");
        for (Lock lock : locks) {
            System.out.println("-------------Tranca [" + indice + "]-----------------");
            print.printClass(lock);
            System.out.print("\n");
            indice++;
        }
        int id = Integer.parseInt(input.nextLine());

        Lock lock = locks.get(id);

        System.out.println("Comece a alteração :");
        System.out.print("Numero de serie antigo:" + lock.getNumberOfSerie() + "\n");
        lock.setNumerOfSerie(input.nextLine());
        System.out.print("Protocolo antigo:" + lock.getProtocol() + "\n");
        lock.setProtocol(input.nextLine());

        managerLock.updateLockController(lock, lock.getId());
    }

    public void deleteUserPage() {
        Scanner input = new Scanner(System.in);
        List<Lock> locks = managerLock.listLockController();

        int indice = 0;

        System.out.println("Digite o indice do User que dejesa deletar");
        for (Lock lock : locks) {
            System.out.println("-------------Tranca [" + indice + "]-----------------");
            print.printClass(lock);
            System.out.print("\n");
            indice++;
        }
        int id = Integer.parseInt(input.nextLine());

        Lock lock = locks.get(id);

        managerLock.deleteLockController(lock.getId());

    }

}
