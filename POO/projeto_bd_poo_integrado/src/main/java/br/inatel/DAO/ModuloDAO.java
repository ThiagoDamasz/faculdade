package br.inatel.DAO;

import br.inatel.Model.Modulo;

import java.sql.SQLException;

public class ModuloDAO extends ConnectionDAO {

    public boolean insertModulo(Modulo modulo) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO modulos (idmodulo, nome) VALUES (?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, modulo.getIdModulo());
            pst.setString(2, modulo.getNome());
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

    public boolean updateModulo(int id, Modulo modulo) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE usuario SET nome = ? WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, modulo.getNome());
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
        String sql = "DELETE FROM modulos WHERE id = ?";
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
