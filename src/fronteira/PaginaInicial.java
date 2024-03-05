package fronteira;

import java.util.Scanner;

import controle.GerenciarUsuario;

public class PaginaInicial {

    public void menu() {

        GerenciarUsuario User = new GerenciarUsuario();

        int opcao;
        while (true) {
            System.out.println("Selecione a opção que deseja ");
            System.out.println("[1] - Cadastrar Usuário");
            System.out.println("[2] - Listar Usuário ");

            Scanner entrada = new Scanner(System.in);
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    User.cadastrarUsuario();
                    break;
                case 2:
                    User.listaUsuarios();
                    break;
                default:
                    break;
            }

        }
    }
}
