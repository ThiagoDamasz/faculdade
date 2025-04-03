public class Cliente {

    public String nome;
    public long cpf;
    public int cont = 0;
    public float total = 0.0f;
    Computador pc[] = new Computador[3];

    public void compra(Computador computador) {
        for (int i = 0; i < 10; i++) {
            if (this.pc[i] == null) {
                this.pc[i] = computador;
                break;
            }
        }
    }

    public float calculaTotalCompra() {

        total = 0.0f; // reseta o total antes de comprar
        for (int i = 0; i < pc.length; i++) {
            if (pc[i] != null) {
                total += pc[i].preco;
            }
        }
        return total;
    }
}
