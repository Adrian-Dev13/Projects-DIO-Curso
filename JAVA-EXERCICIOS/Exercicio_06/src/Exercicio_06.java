import java.util.Scanner;

public class Exercicio_06 {

     public static void main(String[] args){
         var scanner = new Scanner(System.in);
         System.out.println("Informe sua altura em metros:");
         var altura = scanner.nextDouble();
          System.out.println("Informe seu peso:");
          var peso = scanner.nextDouble();
          var imc  = peso/(altura * altura);
          if (imc<=18.5){
               System.out.println("De acordo com IMC você está abaixo do peso");
          } else if (imc<=24.9) {
               System.out.println("De acordo com IMC você está com o peso ideal");
          } else if (imc<=29.9) {
               System.out.println("De acordo com IMC você está levemente acima do peso");
          } else if (imc<=34.9) {
               System.out.println("De acordo com IMC você está tem obesidade grau I");
          } else if (imc<=39.9) {
               System.out.println("De acordo com IMC você está tem obesidade grau II(severa)");
          } else if (imc>=40) {
               System.out.println("De acordo com IMC você está tem obesidade grau III(mórbida)");
          }
     }
}
