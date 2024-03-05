
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        System.out.println("Selecione a opção que deseja ");
        System.out.println("[1] - Cadastrar Usuário");
        System.out.println("[2] - Visualizar Usuário ");
        System.out.println("[3] - Editar Usuário ");
        Scanner entrada = new Scanner(System.in);
        int opcao;
        while (true) {
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar Usuário");
                    break;
                case 2:
                    System.out.println("Visualizar Usuário");
                    break;
                case 3:
                    System.out.println("Editar Usuário");

                    break;

                default:
                    break;
            }

        }
    }
}
