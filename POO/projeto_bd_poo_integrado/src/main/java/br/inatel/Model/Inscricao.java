package br.inatel.Model;

import java.util.Date;

public class Inscricao{
    private int idInscricao;
    private Curso curso;
    private Aluno aluno;
    private Date dataInscricao;

    public Inscricao(int idInscricao, Curso curso, Aluno aluno, Date dataInscricao) {
        this.idInscricao = idInscricao;
        this.curso = curso;
        this.aluno = aluno;
        this.dataInscricao = dataInscricao;
    }

    public int getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(int idInscricao) {
        this.idInscricao = idInscricao;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }
}
