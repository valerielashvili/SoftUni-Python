package p1_Paw_Inc.entities.centers;

import p1_Paw_Inc.entities.animals.Animal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Center {
    private String name;
    private List<Animal> animals;

    protected Center(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(this.animals);
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void addAllAnimals(List<Animal> animals) {
        this.animals.addAll(animals);
    }

    public void removeAnimals(List<Animal> animals) {
        this.animals.removeAll(animals);
    }
}
