package br.inatel.DAO;

import br.inatel.Model.Usuario;

import java.sql.SQLException;

public class UsuarioDAO extends ConnectionDAO {
    public boolean insertUsuario(Usuario usuario) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO usuario (id, nome, email, senha, tipo_usuario) VALUES (?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, usuario.getIdUsuario());
            pst.setString(2, usuario.getNome());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getSenha());
            pst.setInt(5, usuario.getTipo());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    public boolean updateUser(int id, Usuario usuario) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE usuario SET id = ?, nome = ?, email = ?, senha = ?, tipo_usuario = ? WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, usuario.getIdUsuario());
            pst.setString(2, usuario.getNome());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getSenha());
            pst.setInt(5, usuario.getTipo());
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    public boolean deleteUser(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM usuario WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

}
