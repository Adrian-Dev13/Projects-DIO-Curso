import static java.lang.System.*;

public class PetMachine {

    private boolean clean = true;

    private int water = 30;
    private int shampoo = 10;

    private Pet pet;

    public void takeAShower(){
        if (this.pet == null){
            System.out.println("Coloque o pet na máquina para iniciar o banho");
            return;
        }

        this.water -= 10;
        this.shampoo -=2;
       pet.setClean(true);
        System.out.println("O pet "+pet.getName()+" está limpo");
    }

    public void addWater(){
        if (water == 30){
            System.out.println("A capacidade de água da máquina está no máximo");
            return;
        }
        water += 2;
        System.out.println("A máquina está com "+water+"L de água no momento");
    }
    public void addShampoo(){
        if (shampoo == 10){
            System.out.println("A capacidade de shampoo da máquina está no máximo");
            return;
        }
        shampoo += 2;
        System.out.println("A máquina está com "+shampoo+"L de shampoo no momento");
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet(){
        return pet != null;
    }

    public void setPet(Pet pet) {
       if (!this.clean){
           System.out.println("A máquina está suja. para colocar o pet é necessário limpa-lá");
       }
        if (hasPet()){
            System.out.println("O pet "+this.pet.getName()+ " está na máquina nesse momento");
        }

        this.pet = pet;
        System.out.println("O pet "+pet.getName()+" foi colocado na máquina");
    }

    public void removePet(){
        this.clean = this.pet.isClean();

        System.out.println("O pet "+this.pet.getName()+" foi tirado da máquina");

        this.pet = null;

    }

    public void wash(){
        this.water -= 3;
        this.shampoo -=1;
        this.clean = true;
        System.out.println("A máquina foi limpa");

    }

}
