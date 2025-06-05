package br.inatel.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario{

    public Professor(int idUsuario,String nome, String email, String senha) {
        super(idUsuario, nome, email, senha, 2);
    }
}