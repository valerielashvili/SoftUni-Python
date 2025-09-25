package p03_Wild_Farm;

import static p03_Wild_Farm.Main.DECIMAL_FORMAT;

abstract class Mammal extends Animal{
    private String livingRegion;

    Mammal(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]", this.getClass().getSimpleName(), super.getAnimalName(),
                DECIMAL_FORMAT.format(super.getAnimalWeight()), this.livingRegion, super.getFoodEaten());
    }
}
