public class Arma {

    String nome;
    int poder;
    int resistencia;
    String descricao;

    void mostraInfoArma(){
        System.out.println("O nome da arma é: " + nome);
        System.out.println("O poder da arma é: " + poder);
        System.out.println("A resistência da arma é: " + resistencia);
        System.out.println("A descrição da arma é: " + descricao);
    }

    public Arma(String nome, int poder, int resistencia, String descricao ){
        this.nome = nome;
        this.poder = poder;
        this.resistencia = resistencia;
        this.descricao = descricao;
    }

}
