package p03_Wild_Farm;

class Zebra extends Mammal{

    Zebra(String animalName, double animalWeight, String livingRegion) throws IllegalArgumentException {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    protected String makeSound() {
        return "Zs";
    }

    @Override
    protected void eat(Food food, int foodQuantity) throws IllegalArgumentException {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        this.setFoodEaten(foodQuantity);
    }
}
