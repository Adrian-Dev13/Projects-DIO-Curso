import java.util.Scanner;

public class Exercicio_03 {

    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe o valor da base de um retângulo");
        var base_Retangulo = scanner.nextInt();
        System.out.println("Informe o valor da altura de um retângulo");
        var altura_Retangulo = scanner.nextInt();
        var area_Retangulo = altura_Retangulo * base_Retangulo;
        System.out.printf("O valor da área do retângulo é igual a %s", area_Retangulo );
    }
}
