// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cantina cantina = new Cantina();
        cantina.nome = "Cantina";

        Salgado s1 = new Salgado();
        s1.nome = "Coxinha";

        Salgado s2 = new Salgado();
        s2.nome = "Hambúrguer";

        Salgado s3 = new Salgado();
        s3.nome = "Kibe";

        cantina.addSalgado(s1);
        cantina.addSalgado(s2);
        cantina.addSalgado(s3);

        cantina.mostraInfo();

    }
}