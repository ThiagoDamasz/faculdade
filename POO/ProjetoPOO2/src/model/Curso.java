<<<<<<< HEAD
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idCurso;
    private String nome;
    private String descricao;
    private Professor professor;
    private List<Inscricao> inscricoes;

    public Curso(int idCurso, String nome, String descricao, Professor professor) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.descricao = descricao;
        this.professor = professor;
        this.inscricoes = new ArrayList<>();
    }

    // Getters
    public int getIdCurso() {
        return idCurso;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Professor getProfessor() {
        return professor;
    }


    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    // Métodos auxiliares

    public void adicionarInscricao(Inscricao inscricao) {
        inscricoes.add(inscricao);
    }
}
=======
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idCurso;
    private String nome;
    private String descricao;
    private Professor professor;
    private List<Inscricao> inscricoes;

    public Curso(int idCurso, String nome, String descricao, Professor professor) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.descricao = descricao;
        this.professor = professor;
        this.inscricoes = new ArrayList<>();
    }

    // Getters
    public int getIdCurso() {
        return idCurso;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Professor getProfessor() {
        return professor;
    }


    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    // Métodos auxiliares

    public void adicionarInscricao(Inscricao inscricao) {
        inscricoes.add(inscricao);
    }
}
>>>>>>> e50788ab30871a62b5c9afabdd7b8653658b281f
