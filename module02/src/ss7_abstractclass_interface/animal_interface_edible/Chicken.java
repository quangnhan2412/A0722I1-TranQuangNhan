package ss7_abstractclass_interface.animal_interface_edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken : cluck - cluck";
    }

    @Override
    public String howtoEat() {
        return "eat Chicken";
    }
}
