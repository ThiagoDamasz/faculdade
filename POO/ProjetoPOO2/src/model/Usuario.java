<<<<<<< HEAD
package model;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    protected int idUsuario;
    protected String email;
    protected String senha;
    protected String tipo; // aluno ou professor

    protected Perfil perfil;

    public Usuario(int idUsuario, String email, String senha, String tipo) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.perfil = perfil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract boolean autenticar(String email, String senha);


}
=======
package model;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    protected int idUsuario;
    protected String email;
    protected String senha;
    protected String tipo; // aluno ou professor

    protected Perfil perfil;

    public Usuario(int idUsuario, String email, String senha, String tipo) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.perfil = perfil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract boolean autenticar(String email, String senha);


}
>>>>>>> e50788ab30871a62b5c9afabdd7b8653658b281f
