package br.inatel.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int idCurso;
    private String nome;
    private String categoria;
    private String descricao;
    private Professor professor;
    private List<Modulo> modulos;
    private List<Inscricao> inscricoes;

    public Curso(int idCurso, String nome, String descricao, String categoria, Professor professor) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.professor = professor;
        this.modulos = new ArrayList<>();
        this.inscricoes = new ArrayList<>();
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
