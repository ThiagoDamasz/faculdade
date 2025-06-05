package br.inatel.Model;

public class Admin extends Usuario {
    public Admin(int idUsuario,String nome, String email, String senha) {
        super(idUsuario, nome, email, senha, 3);
    }
}