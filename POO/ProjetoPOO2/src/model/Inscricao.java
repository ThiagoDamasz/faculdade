package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Inscricao implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idInscricao;
    private Curso curso;
    private Aluno aluno;
    private LocalDate dataInscricao;

    public Inscricao(int idInscricao, Curso curso, Aluno aluno, LocalDate dataInscricao) {
        this.idInscricao = idInscricao;
        this.curso = curso;
        this.aluno = aluno;
        this.dataInscricao = dataInscricao;
    }

    // Getters
    public int getIdInscricao() {
        return idInscricao;
    }

    public Curso getCurso() {
        return curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public LocalDate getDataInscricao() {
        return dataInscricao;
    }

    // Setters
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setDataInscricao(LocalDate dataInscricao) {
        this.dataInscricao = dataInscricao;
    }


}
