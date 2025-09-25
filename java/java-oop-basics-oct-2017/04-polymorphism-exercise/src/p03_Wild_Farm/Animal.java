package p03_Wild_Farm;

abstract class Animal {
    private String animalName;
    private double animalWeight;
    private int foodEaten;

    Animal(String animalName, double animalWeight) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    String getAnimalName() {
        return this.animalName;
    }

    double getAnimalWeight() {
        return this.animalWeight;
    }

    int getFoodEaten() {
        return this.foodEaten;
    }

    void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected abstract String makeSound();

    protected abstract void eat(Food food, int foodQuantity);
}
