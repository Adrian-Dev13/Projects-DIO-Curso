import java.util.Scanner;

public class Desafio_de_Codigo02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira uma temperatura em graus celsius");
        // Verifica se a próxima entrada é um número do tipo double
        if (scanner.hasNextDouble()) {
            // Lê o valor em Celsius fornecido pelo usuário
            double celsius = scanner.nextDouble();
            if(celsius < -273.15){
                System.out.println("Entrada invalida");
            }else{
                double Fahrenheit = (celsius * 9/5) + 32;
                System.out.println(Fahrenheit);
            }
            // TODO: Verifique se a temperatura fornecida é maior ou igual ao zero absoluto (-273.15°C)
            // TODO: Converta a temperatura de Celsius para Fahrenheit e exiba o resultado formatado com uma casa decimal

        } else {
            // Caso a entrada não seja um número válido, exibe mensagem de erro
            System.out.println("Entrada invalida");
        }

        scanner.close();
    }
}
