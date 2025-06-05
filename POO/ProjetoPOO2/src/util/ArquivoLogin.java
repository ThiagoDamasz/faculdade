package util;

import model.Usuario;

import java.io.*;
import java.util.List;

public class ArquivoLogin {

    private static final String ARQUIVO_USUARIOS = "usuarios.dat";


    public static void salvarUsuarios(List<Usuario> usuarios) { // metodo para salvar os usuarios no arquivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_USUARIOS))) {
            oos.writeObject(usuarios);
            System.out.println("Usuários salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    public static List<Usuario> carregarUsuarios() { // carrega a info do usuario do arquivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            return (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar usuários: " + e.getMessage());
            return null;
        }
    }


}
