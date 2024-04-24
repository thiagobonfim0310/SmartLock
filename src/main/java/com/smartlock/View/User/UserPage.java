package com.smartlock.View.User;

import java.util.Scanner;
import java.util.UUID;
import java.util.List;

import com.smartlock.Business.User.UserFactory;
import com.smartlock.Business.User.UserManager;
import com.smartlock.Business.entities.User;
import com.smartlock.Business.exceptions.EmailNotFoundException;
import com.smartlock.View.util.PrintEntities;

public class UserPage {

    UserManager managerUser;
    PrintEntities print = new PrintEntities();

    public UserPage(UserManager userManager) {
        managerUser = userManager;
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
        // TO-DO : Adicionar o cadastro de tipo
        try {
            managerUser.registerUserController(user);
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

}
