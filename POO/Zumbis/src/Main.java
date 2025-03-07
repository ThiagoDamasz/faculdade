// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Zumbi zumbi1 = new Zumbi();
        zumbi1.nome = "João";
        zumbi1.vida = 200;

        Zumbi zumbi2  = new Zumbi();
        zumbi2.nome = "Renato";
        zumbi2.vida = 100;

        zumbi1 = zumbi2;
        System.out.println(zumbi1.transfereVida(zumbi2,150));
        System.out.println(zumbi2.mostraVida());


    }
}