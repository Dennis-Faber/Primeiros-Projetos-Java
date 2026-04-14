package PastaPrimeiroProjetoAlura;
import java.util.Scanner;

public class PrimeiroProjetoAlura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tipoDeConta = "abc";
        int conta = 0, opcao = 0;
        double valor;
        System.out.println("Digite o nome do Cliente");
        String nomeDoCliente = sc.nextLine();
        //Loop para definir o tipo de conta. Enquanto o tipo de conta for inválido, o programa não segue.
        while (conta != 1 && conta != 2) {
            System.out.println("Escolha o tipo de conta.\n1 - Conta Corrente\n2 - Conta Poupança");
            conta = sc.nextInt();
            sc.nextLine(); //Para pegar o \n que fica sobrando do nextInt
            switch (conta) {
                case 1:
                    tipoDeConta = "Conta corrente";
                    System.out.println("Conta corrente cadastrada");
                    break;
                case 2:
                    tipoDeConta = "Conta poupança";
                    System.out.println("Conta poupança cadastrada");
                    break;
                default:
                    System.out.println("Tipo de conta inválido. Tente novamente");
                    break;
            }
        }
        System.out.println("Digite o saldo inicial do cliente");
        double saldo = sc.nextDouble();
        sc.nextLine(); //Para pegar o \n que fica sobrando do nextDouble
        System.out.printf("""
                
                ***********************************
                Dados iniciais do cliente: %s
                Tipo de conta: %s
                Saldo ininial R$ %.2f
                ***********************************
                """.formatted(nomeDoCliente, tipoDeConta, saldo));

        while (opcao != 4) {
            System.out.println("""
                    \nOperações
                    
                    1 - Consultar saldo
                    2 - Receber Valor
                    3 - Transferir valor
                    4 - Sair
                    
                    Digite a opção desejada:
                    """);
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.printf("O seu saldo atual é: R$ %.2f", saldo);
                    break;
                case 2:
                    System.out.println("Digite qual valor deseja receber em sua conta");
                    valor = sc.nextDouble();
                    if (valor > 0) {
                        saldo += valor;
                        System.out.printf("Saldo atualizado com sucesso. Seu saldo atual é: R$ %.2f", saldo);
                    }
                    else {
                        System.out.println("Você não pode receber valores negativos");
                    }
                    break;
                case 3:
                    System.out.println("Digite qual valor deseja transferir");
                    valor = sc.nextDouble();
                    if (valor > saldo) {
                        System.out.println("Você não possui saldo para essa transação");
                    } else if (valor <= 0) {
                        System.out.println("O valor a ser transferido deve ser maior que zero");
                    } else {
                        saldo -= valor;
                        System.out.printf("Transferência realizada, seu saldo atual é: R$ %.2f", saldo);
                    }
                    break;
                case 4:
                    System.out.println("Fechando aplicação");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
                    break;
            }
        }
        sc.close();
        }
    }
