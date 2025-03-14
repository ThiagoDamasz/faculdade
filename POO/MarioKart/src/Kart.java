public class Kart {
    String nome;
    Piloto piloto;
    Motor motor;

    public Kart(String nome, Piloto piloto){
        this.nome = nome;
        this.piloto = piloto;
        motor = new Motor("100",100);
    }

    void pular(){
        System.out.println( nome + " pulou");
    }
    void soltarTurbo(){
        System.out.println("O " + nome + " está soltando turbo");
    }
    void fazerDrift(){
        System.out.println("O " + piloto.nome + " está fazendo drift");
    }
}
