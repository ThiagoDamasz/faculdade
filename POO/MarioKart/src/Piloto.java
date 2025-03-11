public class Piloto {

    String nome;
    boolean vilao;

    public Piloto(String nome, boolean vilao){
        this.nome = nome;
        this.vilao = vilao;
    }

    void soltaSuperPoder(){
        System.out.println(nome + " Solta a bola de fogo ");
    }
}
