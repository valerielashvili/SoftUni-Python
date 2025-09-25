package p1_Paw_Inc.entities.centers;

import p1_Paw_Inc.entities.animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    public void register(Animal animal) {
        super.addAnimal(animal);
    }

    public List<Animal> sendForCleansing() {
        List<Animal> uncleansed = super.getAnimals().stream().filter(a -> !a.isCleansed()).collect(Collectors.toList());
        super.removeAnimals(uncleansed);

        return uncleansed;
    }

    public List<Animal> sendForCastration() {
        List<Animal> castrated = super.getAnimals().stream().filter(a -> !a.isCleansed()).collect(Collectors.toList());
        super.removeAnimals(castrated);

        return castrated;
    }

    public void receiveAnimals(Animal animal) {
        super.addAnimal(animal);
    }

    public List<Animal> adopt() {
        List<Animal> adoptedAnimals = super.getAnimals().stream().filter(Animal::isCleansed).collect(Collectors.toList());
        super.removeAnimals(adoptedAnimals);
        return adoptedAnimals;
    }

    public long getAdoptedAnimalsCount() {
        return super.getAnimals().stream().filter(Animal::isCleansed).count();
    }
}
