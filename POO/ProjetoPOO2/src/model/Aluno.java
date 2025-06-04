package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String matricula;
    private List<Curso> cursosInscritos;
    private List<Atividade> atividades;

    public Aluno(int idUsuario, String email, String senha, String matricula) {
        super(idUsuario, email, senha, "aluno");
        this.matricula = matricula;
        this.cursosInscritos = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }

    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    // Métodos auxiliares
    public void inscreverCurso(Curso curso) {
        if (!cursosInscritos.contains(curso)) {
            cursosInscritos.add(curso);
        }
    }

    public void adicionarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    @Override
    public boolean autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }
}
