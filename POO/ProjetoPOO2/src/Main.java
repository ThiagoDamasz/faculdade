import model.Aluno;
import model.Professor;
import model.Usuario;
import util.SistemaConta;
import util.SistemaLogin;
import view.MenuPrincipal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaConta sistemaConta = new SistemaConta();
        SistemaLogin sistemaLogin = new SistemaLogin();

        MenuPrincipal.exibir();

        char op = sc.nextLine().charAt(0);

        if(op == 'n')
        {
            sistemaConta.criarConta();
        }

        if(op == 's') {
            Usuario usuarioLogado = sistemaLogin.fazerLogin();

            if (usuarioLogado != null) {
                if (usuarioLogado instanceof Aluno) {
                    // Chamar menu do aluno (a ser implementado)
                    System.out.println("Aluno logado com sucesso.");
                } else if (usuarioLogado instanceof Professor) {
                    // Chamar menu do professor (a ser implementado)
                    System.out.println("Professor logado com sucesso.");
                }
            }
        }


    }
}
