package p1_Paw_Inc.entities.animals;

public class Dog extends Animal {
    private int learnedCommands;

    public Dog(String name, int age, int learnedCommands) {
        super(name, age);
        this.learnedCommands = learnedCommands;
    }
}
