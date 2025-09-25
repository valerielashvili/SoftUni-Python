package p1_Paw_Inc.entities.centers;

import p1_Paw_Inc.entities.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class CastrationCenter extends Center {

    public CastrationCenter(String name) {
        super(name);
    }

    public void registerAnimalsReadyForCastration(List<Animal> readyForCastrationAnimals) {
        super.addAllAnimals(readyForCastrationAnimals);
    }

    public List<Animal> castrate() {
        List<Animal> castratedAnimals = new ArrayList<>(super.getAnimals());/*.stream().filter(a -> !a.isCleansed()).collect(Collectors.toList());*/
        super.removeAnimals(castratedAnimals);

        return castratedAnimals;
    }
}
