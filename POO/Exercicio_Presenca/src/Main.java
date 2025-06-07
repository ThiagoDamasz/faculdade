public class Main {
    public static void main(String[] args) {
        Conta conta = new Conta(1000.0, 500.0);

        Cliente cliente1 = new Cliente("Maria", "111.111.111-11");
        Cliente cliente2 = new Cliente("João", "222.222.222-22");
        Cliente clienteNulo = null;

        conta.adicionarCliente(cliente1);
        conta.adicionarCliente(cliente2);
        conta.adicionarCliente(clienteNulo); // Cliente nulo

        conta.mostrarInfo();
        System.out.println("Programa executado até o final.");
    }
}
