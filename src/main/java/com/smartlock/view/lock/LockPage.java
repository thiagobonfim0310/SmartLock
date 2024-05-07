package com.smartlock.view.lock;

import java.util.List;
import java.util.Scanner;

import org.sqlite.date.ExceptionUtils;

import com.smartlock.business.entities.Enviroments;
import com.smartlock.business.entities.Lock;
import com.smartlock.business.entities.User;
import com.smartlock.business.enviroment.EnviromentManager;
import com.smartlock.business.exceptions.EmailNotFoundException;
import com.smartlock.business.lock.LockManager;
import com.smartlock.business.user.UserManager;
import com.smartlock.view.util.PrintEntities;;

public class LockPage {
    LockManager managerLock;
    EnviromentManager manageEnviroment;
    PrintEntities print = new PrintEntities();

    public LockPage(LockManager lockManager, EnviromentManager enviromentManager) {
        managerLock = lockManager;
        manageEnviroment = enviromentManager;
    }

    public void registerLockPage() {
        Lock lock = new Lock();
        Scanner input = new Scanner(System.in);
        int indice = 0;

        System.out.println("Comece o cadastro :");
        System.out.println("Cadastrar Tranca \n");
        System.out.print("Número de Série: \n");
        lock.setNumerOfSerie(input.nextLine());
        System.out.print("Protocolo: \n");
        lock.setProtocol(input.nextLine());
        System.out.print("Escolha o  Ambiente que a tranca está instalada: \n");
        List<Enviroments> enviroments = manageEnviroment.listEnviromentController();

        System.out.println("Digite o indice do Ambiente que deseja");
        for (Enviroments enviroment : enviroments) {
            System.out.println("-------------Ambiente [" + indice + "]-----------------");
            print.printClass(enviroment);
            System.out.print("\n");
            indice++;
        }
        int id = Integer.parseInt(input.nextLine());
        Enviroments enviroment = enviroments.get(id);

        lock.setEnviroment(enviroment);
        try {
            managerLock.registerLockController(lock);
        } catch (Exception e) {
            System.out.println("Cadastro inválido");
        }
        System.out.print("------------------Cadastro Finalizado------------------ \n");

    }

    public void listLockPage() {
        List<Lock> locks = managerLock.listLockController();

        for (Lock lock : locks) {
            System.out.print("------------------------------------ \n");
            print.printClass(lock);
            System.out.print("\n");
        }
    }

    public void updateLockPage() {
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
        List<Enviroments> enviroments = manageEnviroment.listEnviromentController();
        indice = 0;
        System.out.println("Digite o indice do Ambiente que deseja");
        for (Enviroments enviroment : enviroments) {
            System.out.println("-------------Ambiente [" + indice + "]-----------------");
            print.printClass(enviroment);
            System.out.print("\n");
            indice++;
        }
        id = Integer.parseInt(input.nextLine());
        Enviroments enviroment = enviroments.get(id);

        lock.setEnviroment(enviroment);

        managerLock.updateLockController(lock, lock.getId());
    }

    public void deleteLockPage() {
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
