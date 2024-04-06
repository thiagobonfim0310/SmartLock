package com.smartlock.Business.User;

import java.util.List;
import java.util.Scanner;

import com.smartlock.Business.entities.Address;
import com.smartlock.Business.entities.Administrator;
import com.smartlock.Business.entities.Cashier;
import com.smartlock.Business.entities.User;
import com.smartlock.Infra.Database;

public class UserManager {
    Database data = new Database();

    public void registerUser() {

        System.out.println("Escolha o type de User para cadastrar Admin[1] Cashier[2] :");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        input.nextLine();
        switch (option) {
            case 1:
                Address address = new Address();
                System.out.println("Cadastrar Admin \n");

                Administrator admin = new Administrator();
                System.out.print("Nome: \n");
                admin.setName(input.nextLine());
                System.out.print("Email: \n");
                admin.setEmail(input.nextLine());
                System.out.print("Cpf: \n");
                admin.setCpf(input.nextLine());
                System.out.print("Codigo Da empresa: \n");
                admin.setCompanyCode(input.nextLine());
                System.out.print("Salário: \n");
                admin.setSalary(input.nextInt());
                System.out.print("CEP: \n");
                address.setCep(input.nextLine());
                System.out.print("Pais: \n");
                address.setCountry(input.nextLine());
                System.out.print("Cidade: \n");
                address.setCity(input.nextLine());
                System.out.print("Rua: \n");
                address.setStreet(input.nextLine());
                System.out.print("Numero: \n");
                address.setNumber(input.nextInt());

                admin.setAddress(address);
                System.out.print("------------------Cadastro Finalizado------------------ \n");

                data.saveUser(admin);
                break;
            case 2:
                System.out.println("Cadastrar Usuário");

                Cashier caixa = new Cashier();
                System.out.print("Nome: \n");
                caixa.setName(input.nextLine());
                System.out.print("Email: \n");
                caixa.setEmail(input.nextLine());
                System.out.print("Cpf: \n");
                caixa.setCpf(input.nextLine());
                System.out.print("Codigo Da empresa: \n");
                caixa.setCompanyCode(input.nextLine());
                System.out.print("Salário: \n");
                caixa.setSalary(input.nextInt());
                System.out.print("------------------Cadastro Finalizado------------------ \n");

                data.saveUser(caixa);
                break;
            default:
                break;
        }

    }

    public void listUsers() {
        List<User> usuarios = data.getUsers();
        if (usuarios.size() >= 1) {

            for (User usuario : usuarios) {
                usuario.printData();
            }
        } else {
            System.out.println("Não há usuarios cadastrados \n");
        }

    }
}
