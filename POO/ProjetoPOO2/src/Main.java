import model.Aluno;
import model.Curso;
import model.Professor;
import model.Usuario;
import util.ArquivoCurso;
import util.SistemaConta;
import util.SistemaLogin;
import view.MenuAluno;
import view.MenuPrincipal;
import view.MenuProfessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaConta sistemaConta = new SistemaConta();
        SistemaLogin sistemaLogin = new SistemaLogin();
        List<Curso> listaDeCursos = ArquivoCurso.carregarCursos();
        if (listaDeCursos == null) listaDeCursos = new ArrayList<>();


        MenuPrincipal.exibir();

        char op = sc.nextLine().charAt(0);

        if(op == 'n')
        {
            sistemaConta.criarConta();
        }

        if(op == 's') {
            Usuario usuarioLogado = sistemaLogin.fazerLogin();

            if (usuarioLogado != null) {
                if (usuarioLogado instanceof Aluno aluno) {
                    // Chamar menu do aluno
                    MenuAluno.exibir(aluno, listaDeCursos);
                    System.out.println("Aluno logado com sucesso.");
                } else if (usuarioLogado instanceof Professor professor) {
                    // Chama o menu do professor
                    MenuProfessor.exibirProfessor(professor);
                }
            }
        }


    }
}
