package menu;

import java.util.Scanner;

public class MenuPrincipal {
    public static void exibir() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1. Gerenciar Alunos");
            System.out.println("2. Gerenciar Professores");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    MenuAluno.exibir(sc);
                    break;
                case 2:
                    MenuProfessor.exibir(sc);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
