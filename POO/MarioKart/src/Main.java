// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Piloto p1 = new Piloto("Mario", false);
        Kart k1 = new Kart("Diamond",p1);
        Piloto p2 = new Piloto("Wario", true);
        Kart k2 = new Kart("Rubi", p2);

        k1.motor.velocidadeMaxima = 50;
        k1.motor.mostraInfo();
        k2.motor.mostraInfo();
        k2.piloto.soltaSuperPoder();
        k1.fazerDrift();
        k2.soltarTurbo();
        k1.pular();

    }
}