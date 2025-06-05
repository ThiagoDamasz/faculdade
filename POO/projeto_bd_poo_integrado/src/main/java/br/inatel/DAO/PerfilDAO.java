package br.inatel.DAO;

import br.inatel.Model.Perfil;
import br.inatel.Model.Usuario;

import java.sql.SQLException; // o tipo date de SQL nao em java entao tive que importar essa biblioteca

public class PerfilDAO extends ConnectionDAO {

    public boolean insertPerfil(Perfil perfil) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO perfis (id, data_nascimento) VALUES (?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, perfil.getIdPerfil());
            pst.setDate(2, perfil.getDataNascimento());
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

    public boolean updatePerfil(int idPerfiil, Perfil perfil) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE usuario SET id = ?, data_nascimento WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, perfil.getIdPerfil());
            pst.setDate(2, perfil.getDataNascimento());
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
        String sql = "DELETE FROM perfil WHERE id = ?";
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
