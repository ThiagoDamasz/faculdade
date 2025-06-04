package model;

import java.io.Serializable;

public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idModulo;
    private String titulo;
    private String descricao;
    private Curso curso;

    public Modulo(int idModulo, String titulo, String descricao, Curso curso) {
        this.idModulo = idModulo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.curso = curso;
    }

    // Getters
    public int getIdModulo() {
        return idModulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Curso getCurso() {
        return curso;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
