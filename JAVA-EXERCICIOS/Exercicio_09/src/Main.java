import java.util.Scanner;

public class Main {
    static ContaBancaria contaBancaria = new ContaBancaria();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            var opcoes = -1;

            do {
                System.out.println("===Seja bem-vindo===");
                System.out.println("------------------");
                System.out.println("Escolha uma opção:");
                System.out.println("1-Criar conta");
                System.out.println("2-Acessar conta");
                System.out.println("3-Verificar número de conta");
                System.out.println("4-Verificar número de agência");
                System.out.println("0-Sair");
                opcoes = scanner.nextInt();
                switch (opcoes) {
                    case 1 -> contaBancaria.criarConta();
                    case 2 -> contaBancaria.acessarConta();
                    case 3 -> System.out.println(contaBancaria.getConta());
                    case 4 -> System.out.println(contaBancaria.getAgencia());
                    case 0 -> System.exit(0);
                    default -> System.out.println("Opção inválida");
                }
            } while (true);

    }

    public static void menu(){
      var opcoes = -1;
      do {
          System.out.println("====Menu====");
          System.out.println("Escolha uma das opções");
          System.out.println("1-Consultar saldo");
          System.out.println("2-Consultar cheque especial");
          System.out.println("3-Depositar dinheiro");
          System.out.println("4-Sacar dinheiro");
          System.out.println("5-Pagar um boleto");
          System.out.println("6-Verificar se a conta está usando cheque especial");
          System.out.println("7-Voltar");
          System.out.println("0-Sair");
          opcoes = scanner.nextInt();

          switch (opcoes){
              case 1 -> System.out.println("Saldo: R$"+contaBancaria.getSaldo());
              case 2 -> System.out.println("Limite total do cheque especial: R$"+contaBancaria.getCheque_especial()+
                      "\n Limite utilizado do cheque especial: R$"+contaBancaria.getValorChequeEspecialUsado());
              case 3 -> contaBancaria.depositando();
              case 4 -> contaBancaria.sacando();
              case 5 -> contaBancaria.pagandoBoleto();
              case 6 ->{
                  if(contaBancaria.getValorChequeEspecialUsado() > 0){
                      System.out.println("Você utilizou R$" + String.format("%.2f", contaBancaria.getValorChequeEspecialUsado()) + " do seu limite de cheque especial.");
                  } else {
                      System.out.println("Você não está utilizando o cheque especial.");
                  }
              }
              case 7 -> main(new String[]{});
              case 0 ->System.exit(0);
              default -> System.out.println("Opção inválida");
          }
      }while (true);

    }

}