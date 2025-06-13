import java.util.Scanner;

public class Exercicio_02 {

    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe o valor do lado de um quadrado");
        var lado_Quadrado = scanner.nextInt();
        var area_Quadrado = lado_Quadrado * lado_Quadrado;
        System.out.printf("o valor da área do quadrado é igual a %s", area_Quadrado);
    }
}
