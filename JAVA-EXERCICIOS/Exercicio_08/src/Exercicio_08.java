import java.util.Scanner;

public class Exercicio_08 {

    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe um número:");
        var number = scanner.nextInt();
        var keepVerify = true;
        while (keepVerify){
            System.out.println("Informe um número para verificação");
            var toVerify = scanner.nextInt();
            if (toVerify<number){
                System.out.printf("informe um número maior do que %s\n", number);
                continue;
            }
            var result = toVerify % number;
            keepVerify = result == 0;
            System.out.printf("%s %% %s = %s\n",toVerify, number, result);
        }
    }
}
