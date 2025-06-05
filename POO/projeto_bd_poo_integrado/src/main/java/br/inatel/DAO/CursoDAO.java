package br.inatel.DAO;

import br.inatel.Model.Curso;

import java.sql.SQLException;

public class CursoDAO extends ConnectionDAO {

    public boolean insertUsuario(Curso curso) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO cursos (idcurso, categoria, nome, descricao) VALUES (?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, curso.getIdCurso());
            pst.setString(2, curso.getCategoria());
            pst.setString(3, curso.getNome());
            pst.setString(4, curso.getDescricao());
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

    public boolean updateUser(int id, Curso curso) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE usuario SET  nome = ?, categoria = ?, descricao =  WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, curso.getNome());
            pst.setString(2, curso.getCategoria());
            pst.setString(3, curso.getDescricao());
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