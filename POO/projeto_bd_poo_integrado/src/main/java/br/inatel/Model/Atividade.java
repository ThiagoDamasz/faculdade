package br.inatel.Model;

import java.io.Serializable;

public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idAtividade;
    private String titulo;
    private String descricao;
    private float nota;
    private Aluno aluno;
    private Professor professor;

    public Atividade(int idAtividade, String titulo, String descricao, float nota, Aluno aluno, Professor professor) {
        this.idAtividade = idAtividade;
        this.titulo = titulo;
        this.descricao = descricao;
        this.nota = nota;
        this.aluno = aluno;
        this.professor = professor;
    }
}
