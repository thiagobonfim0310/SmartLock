package com.smartlock.View.User;

import java.util.Scanner;
import java.util.List;

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
        User user = new User();
        Scanner input = new Scanner(System.in);

        System.out.println("Comece o cadastro :");
        System.out.println("Cadastrar Usuario \n");
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
        List<User> users = managerUser.listUserController();

        int indice = 0;

        System.out.println("Digite o indice do User que dejesa atualizar");
        for (User user : users) {
            System.out.println("-------------User " + indice + "-----------------");
            print.printClass(user);
            System.out.print("\n");
            indice++;
        }
    }

}
