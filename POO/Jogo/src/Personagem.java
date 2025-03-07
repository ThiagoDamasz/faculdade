public class Personagem {
    String nome;
    int pontos;
    Arma arma;
    public Personagem(String nome, int pontos){
        this.nome = nome;
        this.pontos = pontos;
    }

    void usarArma(){
        arma.resistencia -= 2;
        System.out.println("Seu personagem perdeu 2 pontos de resistência agora está com " +
        arma.resistencia);
    }

    void tomarDano(){
        pontos -= 5;
        System.out.println("Seu personagem tomou dano agora tem " +
        pontos);
    }

    
}
