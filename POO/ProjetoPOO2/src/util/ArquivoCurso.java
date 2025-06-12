package util;

import model.Curso;

import java.io.*;
import java.util.List;

public class ArquivoCurso {
    private static final String ARQUIVO_CURSOS = "cursos.dat";

    public static void salvarCursos(List<Curso> cursos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CURSOS))) {
            oos.writeObject(cursos);
            System.out.println("Cursos salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar cursos: " + e.getMessage());
        }
    }

    public static List<Curso> carregarCursos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_CURSOS))) {
            return (List<Curso>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar cursos: " + e.getMessage());
            return null;
        }
    }

}