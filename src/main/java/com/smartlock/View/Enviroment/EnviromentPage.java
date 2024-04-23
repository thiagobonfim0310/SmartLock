package com.smartlock.View.Enviroment;

import java.util.Scanner;
import java.util.UUID;
import java.util.List;

import com.smartlock.Business.Enviroment.EnviromentManager;
import com.smartlock.Business.entities.Enviroments;
import com.smartlock.View.util.PrintEntities;

public class EnviromentPage {
    
    EnviromentManager manageEnviroment;
    PrintEntities print = new PrintEntities();

    public EnviromentPage(EnviromentManager enviromentManager) {
        manageEnviroment = enviromentManager;
    }

    public void registerEnviromentPage() {
        Enviroments enviroment = new Enviroments();
        Scanner input = new Scanner(System.in);

        System.out.println("Comece o cadastro: ");
        System.out.println("Cadastrar Ambiente \n");
        System.out.print("Nome: \n");
        enviroment.setName(input.nextLine());
        //TO DO: Fazer a verificação de hierarquias de ambientes
        //TO DO: Adicionar os tratamentos de exceção
        System.out.print("------------------Cadastro Finalizado------------------ \n");

    }

    public void listEnviromentPage() {
        List<Enviroments> enviroments = manageEnviroment.listEnviromentController();

        for (Enviroments enviroment : enviroments) {
            System.out.print("------------------------------------ \n");
            print.printClass(enviroment);
            System.out.print("\n");
        }
    }

    public void updateEnviromentPage() {
        Scanner input = new Scanner(System.in);
        List<Enviroments> enviroments = manageEnviroment.listEnviromentController();

        int indice = 0;

        System.out.println("Digite o indice do Ambiente que deseja");
        for (Enviroments enviroment : enviroments) {
            System.out.println("-------------Ambiente [" + indice + "]-----------------");
            print.printClass(enviroment);
            System.out.print("\n");
            indice++;
        }
        int id = Integer.parseInt(input.nextLine());

        Enviroments enviroment = enviroments.get(id);

        System.out.println("Comece a alteração: ");
        System.out.print("Nome antigo: " + enviroment.getName() + "\n");
        enviroment.setName(input.nextLine());
        
        manageEnviroment.updateEnviromentController(enviroment, enviroment.getId());
    }

    public void deleteEnviromentPage() {
        Scanner input = new Scanner(System.in);
        List<Enviroments> enviroments = manageEnviroment.listEnviromentController();

        int indice = 0;

        System.out.println("Digite o indice do Ambiente que deseja deletar");
        for (Enviroments enviroment : enviroments) {
            System.out.println("-------------Ambiente [" + indice + "]-----------------");
            print.printClass(enviroment);
            System.out.print("\n");
            indice++;
        }
        int id = Integer.parseInt(input.nextLine());

        Enviroments enviroment = enviroments.get(id);

        manageEnviroment.deleteEnviromentController(enviroment.getId());

    }
}
