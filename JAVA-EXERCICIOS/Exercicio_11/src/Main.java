import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static PetMachine petMachine = new PetMachine();
    public static void main(String[] args ){
        var scanner = new Scanner(System.in);
        var opcoes = -1;

        do {
            System.out.println("Escolha uma das opções:");
            System.out.println("========================");
            System.out.println("1- Dar banho no pet");
            System.out.println("2- Abastecer a máquina com água");
            System.out.println("3- Abastecer a máquina com shampoo");
            System.out.println("4- Verificar água da máquina");
            System.out.println("5- Verificar shampoo da máquina");
            System.out.println("6- Verificar se tem pet no banho");
            System.out.println("7- Colocar pet na máquina");
            System.out.println("8- Retirar pet da máquina ");
            System.out.println("9- Limpar máquina");
            System.out.println("0- Sair");
            opcoes = scanner.nextInt();

            switch (opcoes){
                case 1 -> petMachine.takeAShower();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifywater();
                case 5 -> verifyShampoo();
                case 6 -> checkIfHasPetInPetMachine();
                case 7 -> setPetInPetMachine();
                case 8 -> petMachine.removePet();
                case 9 -> petMachine.wash();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }


        }while (true);
    }

    private static void setWater(){
        System.out.println("Tentando colocar água na máquina");
        petMachine.addWater();
    }

    private static void setShampoo(){
        System.out.println("Tentando colocar shampoo na máquina");
        petMachine.addShampoo();
    }

    private static void verifywater() {
        var amount = petMachine.getWater();
        System.out.println(("A máquina esta no momento com " +amount+ " litro(s) de água"));
    }
    private static void verifyShampoo() {
        var amount = petMachine.getShampoo();
        System.out.println(("A máquina esta no momento com " +amount+ " litro(s) de shampoo"));
    }

    private static void checkIfHasPetInPetMachine() {
        var hasPet = petMachine.hasPet();
    System.out.println( hasPet ? "Tem pet na máquina" : "Não tem pet na máquina");
    }

    public static void setPetInPetMachine(){
        var name = "";
        while (name == null || name.isEmpty()){
            System.out.println("Informe o nome do pet:");
            name = scanner.next();
        }
        var pet = new Pet(name);
        petMachine.setPet(pet);
    }

}
