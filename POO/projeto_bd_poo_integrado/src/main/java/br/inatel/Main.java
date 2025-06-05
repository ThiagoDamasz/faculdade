package br.inatel;

import br.inatel.DAO.*;
import br.inatel.Model.*;
import br.inatel.view.*;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.testConnection();

        Menu.menu1();


    }
}
