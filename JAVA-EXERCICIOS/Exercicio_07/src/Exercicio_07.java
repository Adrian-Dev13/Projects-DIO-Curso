import java.util.Scanner;

public class Exercicio_07 {

    public static void main(String[] args){
        var scanner =  new Scanner(System.in);
        System.out.println("Digite um número:");
        var number1 = scanner.nextInt();
        System.out.println("Digite um número maior que o anterior:");
        var number2 = scanner.nextInt();
        while (number2<number1){
            System.out.println("Digite um número maior que o anterior:");
             number2 = scanner.nextInt();
        }
        if(number2>number1){
            System.out.println("Escolha par(p) ou impar(i)");
              var par_impar = scanner.next();
              if (par_impar.equalsIgnoreCase("p")){
                  for (var i=number2;i>=number1;i--){
                      if(i==number2  || i==number1 || i%2==0){
                          System.out.println(i);
                      }
                  }
              } else if (par_impar.equalsIgnoreCase("i")) {
                  for (var i=number2;i>=number1;i--){
                      if(i==number2 || i==number1 || i%2!=0){
                          System.out.println(i);
                      }
                  }
              }else{
                  System.out.println("Valor inválido");

              }
        }
    }
}
