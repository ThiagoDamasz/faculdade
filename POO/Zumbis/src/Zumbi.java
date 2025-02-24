public class Zumbi {

    String nome;
    double vida;
    public Zumbi(){
        System.out.println("Esse construtor foi chamado");
    }
    double mostraVida(){
        return vida;
    }
    boolean transfereVida(Zumbi zumbiAlvo, double quantia){
        if(quantia <= 100){
            zumbiAlvo.vida += quantia;
            return true;
        }

        else {
            return false;
        }
    }
}
