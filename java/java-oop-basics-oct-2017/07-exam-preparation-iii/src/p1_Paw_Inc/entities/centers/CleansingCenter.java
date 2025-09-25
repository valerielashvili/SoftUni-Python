package p1_Paw_Inc.entities.centers;

import p1_Paw_Inc.entities.animals.Animal;

import java.util.List;
import java.util.stream.Collectors;

public class CleansingCenter extends Center {

    public CleansingCenter(String name) {
        super(name);
    }

    public void registerUncleansedAnimals(List<Animal> uncleansedAnimals) {
        super.addAllAnimals(uncleansedAnimals);
    }

    public List<Animal> cleanse() {
        List<Animal> cleansedAnimals = super.getAnimals().stream().peek(Animal::cleanse).collect(Collectors.toList());
        super.removeAnimals(cleansedAnimals);

        return cleansedAnimals;
    }

    public int getCleansedAnimalsCount() {
        return super.getAnimals().size();
    }
}
