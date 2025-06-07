<<<<<<< HEAD
package util;

import model.Aluno;
import model.Professor;
import model.Usuario;
import util.ArquivoLogin;

import java.util.List;
import java.util.Scanner;

public class SistemaLogin {

    public Usuario fazerLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Login ===");
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        List<Usuario> usuarios = ArquivoLogin.carregarUsuarios(); // puxa a info do arquivo
        if (usuarios == null || usuarios.isEmpty()) { // verifica se esta vazio
            System.out.println("Nenhum usuário cadastrado.");
            return null;
        }

        for (Usuario u : usuarios) { // varre a lista e confirma o login com o metodo autenticar
            if (u.autenticar(email, senha)) {
                System.out.println("Login realizado com sucesso como " + u.getTipo() + "!");
                return u;
            }
        }

        System.out.println("Erro no login: Email ou senha inválidos.");
        return null;
    }
}
=======
package util;

import model.Aluno;
import model.Professor;
import model.Usuario;
import util.ArquivoLogin;

import java.util.List;
import java.util.Scanner;

public class SistemaLogin {

    public Usuario fazerLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Login ===");
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        List<Usuario> usuarios = ArquivoLogin.carregarUsuarios(); // puxa a info do arquivo
        if (usuarios == null || usuarios.isEmpty()) { // verifica se esta vazio
            System.out.println("Nenhum usuário cadastrado.");
            return null;
        }

        for (Usuario u : usuarios) { // varre a lista e confirma o login com o metodo autenticar
            if (u.autenticar(email, senha)) {
                System.out.println("Login realizado com sucesso como " + u.getTipo() + "!");
                return u;
            }
        }

        System.out.println("Erro no login: Email ou senha inválidos.");
        return null;
    }
}
>>>>>>> e50788ab30871a62b5c9afabdd7b8653658b281f
