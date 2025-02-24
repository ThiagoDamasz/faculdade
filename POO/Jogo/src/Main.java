// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Personagem p1 = new Personagem("Thiago ", 20);
        p1.arma = new Arma("Chaos Blade", 100, 20, "Lamina mortal");

        System.out.println("Bem vindo " + p1.nome + "você começa o jogo com " +
        p1.pontos + " pontos de vida");

        System.out.println("Aqui está seu equipamento, guarde com todas as suas forças");
        p1.arma.mostraInfoArma();

        System.out.println("Um inimigo poderoso se aproxima");
        p1.usarArma();
        p1.tomarDano();

    }
}