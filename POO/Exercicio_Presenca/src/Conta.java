import java.util.HashSet;

public class Conta {
    private double saldo;
    private double limite;
    private HashSet<Cliente> clientes;

    public Conta(double saldo, double limite) {
        this.saldo = saldo;
        this.limite = limite;
        this.clientes = new HashSet<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void mostrarInfo() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Limite: " + limite);
        System.out.println("Informações dos clientes:");

        for (Cliente cliente : clientes) {
            try {
                cliente.mostrarInfo();
            } catch (NullPointerException e) {
                System.out.println("Cliente nulo encontrado.");
            }
        }
    }
}
