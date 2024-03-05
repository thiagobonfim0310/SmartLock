package controle;

import java.util.List;
import java.util.Scanner;

import entities.Administrador;
import entities.Caixa;
import entities.Endereco;
import entities.Usuario;
import fronteira.BancoDeDados;

public class GerenciarUsuario {
    BancoDeDados dados = new BancoDeDados();

    public void cadastrarUsuario() {

        System.out.println("Escolha o tipo de Usuario para cadastrar Admin[1] Caixa[2] :");

        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();
        entrada.nextLine();
        switch (opcao) {
            case 1:
                Endereco endereco = new Endereco();
                System.out.println("Cadastrar Admin \n");

                Administrador admin = new Administrador();
                System.out.print("Nome: \n");
                admin.setNome(entrada.nextLine());
                System.out.print("Email: \n");
                admin.setEmail(entrada.nextLine());
                System.out.print("Cpf: \n");
                admin.setCpf(entrada.nextLine());
                System.out.print("Codigo Da empresa: \n");
                admin.setCodigoEmpresa(entrada.nextLine());
                System.out.print("Salário: \n");
                admin.setSalario(entrada.nextInt());
                System.out.print("CEP: \n");
                endereco.setCep(entrada.nextLine());
                System.out.print("Pais: \n");
                endereco.setPais(entrada.nextLine());
                System.out.print("Cidade: \n");
                endereco.setCidade(entrada.nextLine());
                System.out.print("Rua: \n");
                endereco.setRua(entrada.nextLine());
                System.out.print("Numero: \n");
                endereco.setNumero(entrada.nextInt());

                admin.setEndereco(endereco);
                System.out.print("------------------Cadastro Finalizado------------------ \n");

                dados.salvarUsuarios(admin);
                break;
            case 2:
                System.out.println("Cadastrar Usuário");

                Caixa caixa = new Caixa();
                System.out.print("Nome: \n");
                caixa.setNome(entrada.nextLine());
                System.out.print("Email: \n");
                caixa.setEmail(entrada.nextLine());
                System.out.print("Cpf: \n");
                caixa.setCpf(entrada.nextLine());
                System.out.print("Codigo Da empresa: \n");
                caixa.setCodigoEmpresa(entrada.nextLine());
                System.out.print("Salário: \n");
                caixa.setSalario(entrada.nextInt());
                System.out.print("------------------Cadastro Finalizado------------------ \n");

                dados.salvarUsuarios(caixa);
                break;
            default:
                break;
        }

    }

    public void listaUsuarios() {
        List<Usuario> usuarios = dados.resgatarUsuarios();
        if (usuarios.size() >= 1) {

            for (Usuario usuario : usuarios) {
                usuario.imprimirDados();
            }
        } else {
            System.out.println("Não há usuarios cadastrados \n");
        }

    }
}
