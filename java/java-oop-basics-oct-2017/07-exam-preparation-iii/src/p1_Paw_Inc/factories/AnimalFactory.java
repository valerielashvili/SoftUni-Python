package p1_Paw_Inc.factories;

import p1_Paw_Inc.entities.animals.Cat;
import p1_Paw_Inc.entities.animals.Dog;

public final class AnimalFactory {
    private AnimalFactory() {
    }

    public static Dog createDog(String name, int age, int learnedCommands) {
        return new Dog(name, age, learnedCommands);
    }

    public static Cat createCat(String name, int age, int intelligenceCoefficient) {
        return new Cat(name, age, intelligenceCoefficient);
    }
}
