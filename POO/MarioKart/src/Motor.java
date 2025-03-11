public class Motor {

    String cilindradas;
    float velocidadeMaxima;

    public Motor(String cilindradas, float velocidadeMaxima){
        this.cilindradas = cilindradas;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    void mostraInfo(){
        System.out.println("O motor deste kart tem " + cilindradas + " cilindradas");
        System.out.println("A velocidade máxima deste kart é: " + velocidadeMaxima);
    }
}
