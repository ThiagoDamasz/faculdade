public class SistemaOperacional { // aqui também precisa do encapsulamento pois o sistema nao pode ser acesasado

    private String nome;
    private int tipo;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getTipo() {
        return tipo;
    }



}
