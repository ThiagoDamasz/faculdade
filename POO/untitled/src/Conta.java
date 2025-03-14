public class Conta {

    float saldo;
    int limite;
    float numeroDaConta;
    String nomeDoDono;

    public void sacar(int quantidade){
        saldo -= quantidade;
    }

    public void depositar(int quantidade){
        saldo += quantidade;
    }
}
