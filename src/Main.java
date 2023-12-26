import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        String conta;
        Scanner scan = new Scanner(System.in);
        System.out.println("Gostaria de criar uma conta? (s/n)");
        String simOuNao = scan.next();
        if (simOuNao.compareTo("s") == 0 || simOuNao.compareTo("sim") == 0 || simOuNao.compareTo("Sim") == 0 || simOuNao.compareTo("S") == 0) {
            System.out.println("Qual seu nome?");
            cliente.setNome(scan.next());
            System.out.println("Qual sua idade?");
            cliente.setIdade(scan.nextInt());
            if (cliente.getIdade() < 18) {
                System.out.println("Você não tem idade suficiente para ter uma conta nesse banco");
                return;
            }
            System.out.println("Qual conta gostaria de criar?");
            conta = scan.next();
            if (conta.compareTo("Poupanca") == 0 || conta.compareTo("poupanca") == 0) {
                ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);
                ContaCorrente contaCorrente = null;
                System.out.println("Deseja criar uma conta corrente também? (s/n)");
                simOuNao = scan.next();
                if (simOuNao.compareTo("s") == 0 || simOuNao.compareTo("sim") == 0 || simOuNao.compareTo("Sim") == 0) {
                    contaCorrente = new ContaCorrente(cliente);
                }
                int opcao;
                do {
                    System.out.println("Você possui essas opções:");
                    System.out.println("1 - Imprimir Extrato");
                    System.out.println("2 - Transferência");
                    System.out.println("3 - Deposito");
                    System.out.println("0 - Sair");
                    System.out.println("Qual desses serviços voce gostaria de utilizar?");
                    opcao = scan.nextInt();

                    if (opcao == 1) {
                        System.out.println("Qual conta gostaria de imprimir o extrato?");
                        conta = scan.next();
                        if (conta.compareTo("Poupanca") == 0 || conta.compareTo("poupanca") == 0) {
                            contaPoupanca.imprimirExtrato();
                        } else if (conta.compareTo("Corrente") == 0 || conta.compareTo("corrente") == 0) {
                            if (contaCorrente == null) {
                                System.out.println("Não possui conta corrente!");
                            } else {
                                contaCorrente.imprimirExtrato();
                            }
                        }
                    } else if (opcao == 2) {
                        System.out.println("De qual conta voce gostaria de transferir?");
                        conta = scan.next();
                        if (conta.compareTo("Poupanca") == 0 || conta.compareTo("poupanca") == 0) {
                            if (contaCorrente != null) {
                                System.out.println("Insira o valor gostaria de transferir");
                                double valor = scan.nextDouble();
                                contaPoupanca.transferir(valor, contaCorrente);
                            } else {
                                System.out.println("Não possui conta corrente para transferir!");
                            }
                        } else if (conta.compareTo("Corrente") == 0 || conta.compareTo("corrente") == 0) {
                            if (contaCorrente == null) {
                                System.out.println("Não possui conta corrente!");
                            } else {
                                System.out.println("Insira o valor gostaria de transferir");
                                double valor = scan.nextDouble();
                                contaCorrente.transferir(valor, contaPoupanca);
                            }
                        }
                    } else if (opcao == 3) {
                        System.out.println("Qual conta gostaria de depositar?");
                        conta = scan.next();
                        if (conta.compareTo("Poupanca") == 0 || conta.compareTo("poupanca") == 0) {
                            System.out.println("Insira o valor que gostaria de depositar");
                            double valor = scan.nextDouble();
                            contaPoupanca.depositar(valor);
                        } else if (conta.compareTo("Corrente") == 0 || conta.compareTo("corrente") == 0) {
                            if (contaCorrente == null) {
                                System.out.println("Não possui conta corrente!");
                            } else {
                                System.out.println("Insira o valor que gostaria de depositar");
                                double valor = scan.nextDouble();
                                contaCorrente.depositar(valor);
                            }
                        }
                    }
                } while (opcao != 0);

            } else if (conta.compareTo("Corrente") == 0 || conta.compareTo("corrente") == 0) {
                ContaCorrente contaCorrente = new ContaCorrente(cliente);
                System.out.println("Deseja criar uma conta poupança também? (s/n)");
                simOuNao = scan.next();
                ContaPoupanca contaPoupanca = null;
                if (simOuNao.compareTo("s") == 0 || simOuNao.compareTo("sim") == 0 || simOuNao.compareTo("Sim") == 0) {
                    contaPoupanca = new ContaPoupanca(cliente);
                }
                int opcao;
                do {
                    System.out.println("Você possui essas opções:");
                    System.out.println("1 - Imprimir Extrato");
                    System.out.println("2 - Transferência");
                    System.out.println("3 - Deposito");
                    System.out.println("0 - Sair");
                    System.out.println("Qual desses serviços voce gostaria de utilizar?");
                    opcao = scan.nextInt();

                    if (opcao == 1) {
                        System.out.println("Qual conta gostaria de imprimir o extrato?");
                        conta = scan.next();
                        if (conta.compareTo("Poupanca") == 0 || conta.compareTo("poupanca") == 0) {
                            if (contaPoupanca == null) {
                                System.out.println("Não possui conta poupança!");
                            } else {
                                contaPoupanca.imprimirExtrato();
                            }
                        } else if (conta.compareTo("Corrente") == 0 || conta.compareTo("corrente") == 0) {
                            contaCorrente.imprimirExtrato();
                        }
                    } else if (opcao == 2) {
                        System.out.println("De qual conta voce gostaria de transferir?");
                        conta = scan.next();
                        if (conta.compareTo("Poupanca") == 0 || conta.compareTo("poupanca") == 0) {
                            if (contaPoupanca == null) {
                                System.out.println("Não possui conta poupanca!");
                            } else {
                                System.out.println("Insira o valor gostaria de transferir");
                                double valor = scan.nextDouble();
                                contaPoupanca.transferir(valor, contaCorrente);
                            }
                        } else if (conta.compareTo("Corrente") == 0 || conta.compareTo("corrente") == 0) {
                            if (contaPoupanca != null) {
                                System.out.println("Insira o valor gostaria de transferir");
                                double valor = scan.nextDouble();
                                contaCorrente.transferir(valor, contaPoupanca);
                            } else {
                                System.out.println("Não possui conta poupança para transferir!");
                            }
                        }
                    } else if (opcao == 3) {
                        System.out.println("Qual conta gostaria de depositar?");
                        conta = scan.next();
                        if (conta.compareTo("Poupanca") == 0 || conta.compareTo("poupanca") == 0) {
                            if (contaPoupanca == null) {
                                System.out.println("Não possui conta poupança!");
                            } else {
                                System.out.println("Insira o valor que gostaria de depositar");
                                double valor = scan.nextDouble();
                                contaPoupanca.depositar(valor);
                            }
                        } else if (conta.compareTo("Corrente") == 0 || conta.compareTo("corrente") == 0) {
                            System.out.println("Insira o valor que gostaria de depositar");
                            double valor = scan.nextDouble();
                            contaCorrente.depositar(valor);
                        }
                    }
                } while (opcao != 0);
            }
        }
    }

}
