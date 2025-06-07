<<<<<<< HEAD
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Curso> cursosMinistrados;

    public Professor(int idUsuario, String email, String senha) {
        super(idUsuario, email, senha, "professor");
        this.cursosMinistrados = new ArrayList<>();
    }

    // Getter
    public List<Curso> getCursosMinistrados() {
        return cursosMinistrados;
    }

    // Método auxiliar
    public void adicionarCurso(Curso curso) {
        if (!cursosMinistrados.contains(curso)) {
            cursosMinistrados.add(curso);
        }
    }

    @Override
    public boolean autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

}
=======
<<<<<<< HEAD
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Curso> cursosMinistrados;

    public Professor(int idUsuario, String email, String senha) {
        super(idUsuario, email, senha, "professor");
        this.cursosMinistrados = new ArrayList<>();
    }

    // Getter
    public List<Curso> getCursosMinistrados() {
        return cursosMinistrados;
    }

    // Método auxiliar
    public void adicionarCurso(Curso curso) {
        if (!cursosMinistrados.contains(curso)) {
            cursosMinistrados.add(curso);
        }
    }

    @Override
    public boolean autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

}
=======
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Curso> cursosMinistrados;

    public Professor(int idUsuario, String email, String senha) {
        super(idUsuario, email, senha, "professor");
        this.cursosMinistrados = new ArrayList<>();
    }

    // Getter
    public List<Curso> getCursosMinistrados() {
        return cursosMinistrados;
    }

    // Método auxiliar
    public void adicionarCurso(Curso curso) {
        if (!cursosMinistrados.contains(curso)) {
            cursosMinistrados.add(curso);
        }
    }

    @Override
    public boolean autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

}
>>>>>>> 9919fa14457c0db86d33baeeed290019f6e93e4a
>>>>>>> e50788ab30871a62b5c9afabdd7b8653658b281f
