package view;

import model.*;
import util.ArquivoCurso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuProfessor {

    public static void exibirProfessor(Professor professor) {
        Scanner sc = new Scanner(System.in);
        char op;

        do {
            System.out.println("\n=== Menu do Professor ===");
            System.out.println("1 - Criar curso");
            System.out.println("2 - Ver integrantes de um curso");
            System.out.println("3 - Ver Cursos ministrados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextLine().charAt(0);

            switch (op) {
                case '1':
                    criarCurso(professor);
                    break;
                case '2':
                    verIntegrantesCurso(professor);
                    break;
                case '3':
                    mostraCursoProfessor(professor);
                    break;
                case '0':
                    System.out.println("Saindo do menu do professor...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (op != '0');

    }

    private static void criarCurso(Professor professor) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== Criar Curso ===");
        System.out.print("Nome do curso: ");
        String nome = sc.nextLine();

        System.out.print("Descrição do curso: ");
        String descricao = sc.nextLine();

        int novoId = professor.getCursosMinistrados().size() + 1;
        Curso novoCurso = new Curso(novoId, nome, descricao, professor);

        professor.adicionarCurso(novoCurso); // 1. Adiciona ao professor

        // 2. Adiciona à lista geral de cursos e salva no arquivo
        List<Curso> todosCursos = ArquivoCurso.carregarCursos();
        if (todosCursos == null) todosCursos = new ArrayList<>();
        todosCursos.add(novoCurso);
        ArquivoCurso.salvarCursos(todosCursos);

        System.out.println("Curso criado com sucesso!");
    }


    private static void verIntegrantesCurso(Professor professor) {
        Scanner sc = new Scanner(System.in);

        if (professor.getCursosMinistrados().isEmpty()) {
            System.out.println("Você ainda não criou nenhum curso.");
            return;
        }

        // Listar os cursos do professor
        System.out.println("\n=== Seus Cursos ===");
        for (int i = 0; i < professor.getCursosMinistrados().size(); i++) {
            Curso c = professor.getCursosMinistrados().get(i);
            System.out.printf("%d - %s\n", i + 1, c.getNome());
        }

        System.out.print("Escolha o número do curso para ver os integrantes: ");
        int indice = Integer.parseInt(sc.nextLine()) - 1;

        if (indice < 0 || indice >= professor.getCursosMinistrados().size()) {
            System.out.println("Curso inválido.");
            return;
        }

        Curso cursoEscolhido = professor.getCursosMinistrados().get(indice);

        List<Inscricao> inscricoes = cursoEscolhido.getInscricoes();

        if (inscricoes.isEmpty()) {
            System.out.println("Nenhum aluno inscrito neste curso.");
            return;
        }

        System.out.println("\n=== Alunos inscritos no curso " + cursoEscolhido.getNome() + " ===");
        for (Inscricao i : inscricoes) {
            Aluno aluno = i.getAluno();
            System.out.println("Aluno: " + aluno.getEmail() + " | Matrícula: " + aluno.getMatricula() + " | Data de inscrição: " + i.getDataInscricao());
        }
    }

    private static void mostraCursoProfessor(Professor professor){
        List<Curso> cursosprof = professor.getCursosMinistrados();
        if (cursosprof.isEmpty()){
            System.out.println("Você ainda não ministra nenhum curso");
        }
        else {
            System.out.println("Cursos ministrados: ");
            for (Curso c: cursosprof){
                System.out.println(c.getNome() + " " + c.getDescricao());
            }
        }
    }


}