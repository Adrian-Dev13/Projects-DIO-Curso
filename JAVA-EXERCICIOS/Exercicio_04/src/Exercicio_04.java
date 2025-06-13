import java.util.Scanner;

public class Exercicio_04 {

    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe o nome da primeira pessoa:");
        var name1 = scanner.next();
        System.out.println("Informe sua idade:");
        var idade1 = scanner.nextInt();
        System.out.println("Informe o nome da segunda pessoa:");
        var name2 = scanner.next();
        System.out.println("Informe sua idade:");
        var idade2 = scanner.nextInt();
        var diff_Idade = idade1 - idade2;
        var modulo = Math.abs(diff_Idade);
        System.out.printf("A diferença de idade entre %s e %s é de %s\n", name1, name2, modulo);
    }
}
