import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Cliente cliente = new Cliente();
        Scanner scan = new Scanner(System.in);
        System.out.println("Gostaria de criar uma conta? (s/n)");
        String conta = scan.next();
        if(conta.compareTo("s") == 0 || conta.compareTo("sim") == 0 || conta.compareTo("Sim") == 0){
            System.out.println("Qual seu nome?");
            cliente.setNome(scan.next());
            System.out.println("Qual sua idade?");
            cliente.setIdade(scan.next());
            System.out.println("Qual conta gostaria de criar?");
            conta = scan.next();
            if(conta.compareTo("Poupanca") == 0 || conta.compareTo("poupanca") == 0){
                ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);
                contaPoupanca.depositar(1500);
                contaPoupanca.imprimirExtrato();
            } else if (conta.compareTo("Corrente") == 0 || conta.compareTo("corrente") == 0) {
                ContaCorrente contaCorrente = new ContaCorrente(cliente);
                contaCorrente.imprimirExtrato();
            }
            //TODO: Adicionar a opções de criar mais uma conta
            // adicionar as opçoes de utilizar os serviços (Transferencia, deposito, imprimir extrato)
            // depois refatorar isso tudo separando em funções
        }
    }

}
