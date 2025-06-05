package br.inatel.Model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private String matricula;
    private List<Curso> cursosInscritos;
    private List<Atividade> atividades;

    public Aluno(int idUsuario, String email, String senha, String matricula) {
        super(idUsuario, email, senha, "aluno");
        this.matricula = matricula;
        this.cursosInscritos = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }

}
