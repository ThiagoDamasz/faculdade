package br.inatel.Model;

import java.util.Date;

public class Perfil  {

    private int idPerfil;
    private String nome;
    private String telefone;
    private Date dataNascimento;

    private Usuario usuario;

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public java.sql.Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

