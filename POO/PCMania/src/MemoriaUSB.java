public class MemoriaUSB {
    private String nome;
    private int capacidade;

    public MemoriaUSB(String nome, int capacidade) { // construtor e gets e sets da memmoria para usar depois
        this.nome = nome;
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

}
