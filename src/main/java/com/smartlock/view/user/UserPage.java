package com.smartlock.view.user;

import java.util.Scanner;
import java.util.UUID;
import java.util.List;

import com.smartlock.business.entities.Enviroments;
import com.smartlock.business.entities.User;
import com.smartlock.business.enviroment.EnviromentManager;
import com.smartlock.business.exceptions.EmailNotFoundException;
import com.smartlock.business.user.UserFactory;
import com.smartlock.business.user.UserManager;

import com.smartlock.view.util.PrintEntities;

public class UserPage {

    UserManager managerUser;
    EnviromentManager managerEnviroment;
    PrintEntities print = new PrintEntities();

    public UserPage(UserManager userManager, EnviromentManager enviromentManager) {
        managerUser = userManager;
        managerEnviroment = enviromentManager;
    }

    public void registerUserPage() {
        User user;
        Scanner input = new Scanner(System.in);

        System.out.println("Comece o cadastro: ");
        System.out.println("Cadastrar Usuario \n");
        System.out.println("Qual o tipo  Professor[1], Aluno[2], Genérico[3] \n");
        int id = Integer.parseInt(input.nextLine());
        switch (id) {
            case 1:
                user = UserFactory.criarUsuario("professor");
                break;
            case 2:
                user = UserFactory.criarUsuario("aluno");
                break;

            default:
                user = UserFactory.criarUsuario("generico");
                break;
        }
        System.out.print("Nome: \n");
        user.setName(input.nextLine());
        System.out.print("Email: \n");
        user.setEmail(input.nextLine());
        System.out.print("Cpf: \n");
        user.setCpf(input.nextLine());
        System.out.print("Foto de perfil: \n");
        user.setProfileImage(input.nextLine());
        // TO-DO : Adicionar o cadastro de tipo
        try {
            managerUser.registerUserController(user, user.getProfileImage());
        } catch (EmailNotFoundException e) {
            System.out.println("Email inválido");
        }
        System.out.print("------------------Cadastro Finalizado------------------ \n");

    }

    public void listUserPage() {
        List<User> users = managerUser.listUserController();

        for (User user : users) {
            System.out.print("------------------------------------ \n");
            print.printClass(user);
            System.out.print("\n");
        }
    }

    public void updateUserPage() {
        Scanner input = new Scanner(System.in);
        List<User> users = managerUser.listUserController();

        int indice = 0;

        System.out.println("Digite o indice do User que deseja atualizar");
        for (User user : users) {
            System.out.println("-------------User [" + indice + "]-----------------");
            print.printClass(user);
            System.out.print("\n");
            indice++;
        }
        int id = Integer.parseInt(input.nextLine());

        User user = users.get(id);

        System.out.println("Comece a alteração: ");
        System.out.print("Nome antigo: " + user.getName() + "\n");
        user.setName(input.nextLine());
        System.out.print("Email antigo: " + user.getEmail() + "\n");
        user.setEmail(input.nextLine());
        System.out.print("Cpf antigo: " + user.getCpf() + "\n");
        user.setCpf(input.nextLine());

        managerUser.updateUserController(user, user.getId());

    }

    public void deleteUserPage() {
        Scanner input = new Scanner(System.in);
        List<User> users = managerUser.listUserController();

        int indice = 0;

        System.out.println("Digite o indice do User que dejesa deletar");
        for (User user : users) {
            System.out.println("-------------User [" + indice + "]-----------------");
            print.printClass(user);
            System.out.print("\n");
            indice++;
        }
        int id = Integer.parseInt(input.nextLine());

        User user = users.get(id);

        managerUser.deleteUserController(user.getId());

    }

    public void acessUserEnviromentPage() {
        Scanner input = new Scanner(System.in);
        List<User> users = managerUser.listUserController();

        int indice = 0;

        System.out.println("Digite o indice do User que deseja dar acesso");
        for (User user : users) {
            System.out.println("-------------User [" + indice + "]-----------------");
            print.printClass(user);
            System.out.print("\n");
            indice++;
        }
        int indiceUser = Integer.parseInt(input.nextLine());
        User user = users.get(indiceUser);
        List<Enviroments> enviroments = managerEnviroment.listEnviromentController();

        indice = 0;

        System.out.println("Digite o indice do Ambiente que dar acesso");
        for (Enviroments enviroment : enviroments) {
            System.out.println("-------------Ambiente [" + indice + "]-----------------");
            print.printClass(enviroment);
            System.out.print("\n");
            indice++;
        }
        int indiceEnviroment = Integer.parseInt(input.nextLine());

        Enviroments enviroment = enviroments.get(indiceEnviroment);

        managerUser.acessUserEnviromentController(user.getId(), enviroment.getId());

    }

}
