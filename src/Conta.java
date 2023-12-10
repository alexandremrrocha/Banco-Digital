public abstract class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void depositar(double valor){
        this.saldo = saldo + valor;
    }

    public void sacar(double valor){
        this.saldo = saldo - valor;
    }

    public void transferir(double valor, Conta contaDestino){
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimeInfoGeral(){
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Idade do Titular: %s%n", this.cliente.getIdade());
        System.out.printf("Agência Banco: %d%n", this.agencia);
        System.out.printf("Número Banco: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}
