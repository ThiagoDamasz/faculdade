package model;

import model.Aluno;
import model.Professor;

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

    public int getIdAtividade() {
        return idAtividade;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getNota() {
        return nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
