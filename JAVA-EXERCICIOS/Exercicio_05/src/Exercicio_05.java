import java.util.Scanner;

public class Exercicio_05 {

    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe um número:");
        var number = scanner.nextInt();
        for(var i = 1;i<=10;i++){
            var tabuada = number * i;
            System.out.printf("%s x %s = %s\n", number, i, tabuada);
        }
    }
}
