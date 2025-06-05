package br.inatel.Model;

import java.io.Serializable;

public class Modulo{
    private int idModulo;
    private String nome;
    private String descricao;
    private Curso curso;

    public Modulo(int idModulo, String nome, String descricao, Curso curso) {
        this.idModulo = idModulo;
        this.nome = nome;
        this.descricao = descricao;
        this.curso = curso;
    }

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
