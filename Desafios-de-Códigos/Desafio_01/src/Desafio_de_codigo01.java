import java.util.Scanner;

public class Desafio_de_codigo01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expectedDomain = "@company.com";
        System.out.print("Digite seu e-mail corporativo: ");
        String email = scanner.nextLine().trim();

        // TODO: Verifique se o e-mail contém o domínio esperado
        if (email.toLowerCase().endsWith(expectedDomain)) {
            System.out.println("E-mail valido");
        }else {
            System.out.println("E-mail invalido");
        }
        scanner.close();
    }
}
