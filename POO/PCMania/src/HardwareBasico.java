public class HardwareBasico { // tanto na memoria quanto no hadware acho que é preciso encapsular pois o usuario nao tem acesso a essas informacoes
    private String nome;
    private float capacidade;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCapacidade(float capacidade) {
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public float getCapacidade() {
        return capacidade;
    }

}
