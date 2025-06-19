import java.util.Scanner;

public class Main {
  static Scanner scanner = new Scanner(System.in);
  static Carro porsche = new Carro();
  public static void main(String[] args){
   int opcoes = -1;

  do{
    System.out.print("\nSeja bem-vindo ao menu interativo Porsche");
    System.out.println("\n");
    System.out.println("=========Menu===========");
    System.out.println("1-Ligar o carro");
    System.out.println("2-Desligar o carro");
    System.out.println("3-Acelerar");
    System.out.println("4-Diminuir velocidade");
    System.out.println("5-Virar para esquerda/direita");
    System.out.println("6-Verificar velocidade");
    System.out.println("7-Trocar a marcha");
    System.out.println("0-Sair");
    opcoes = scanner.nextInt();

    switch (opcoes){
     case 1 -> porsche.ligar();
     case 2 -> porsche.desligar();
     case 3 -> porsche.acelerar();
     case 4 -> porsche.diminuirVelocidade();
     case 5 -> porsche.virar();
     case 6 -> porsche.verificarVelocidade();
     case 7 -> porsche.trocarMarcha();
     case 0 -> System.exit(0);
     default -> System.out.println("Opção inválida");
    }
   }while (true);

  }
}
