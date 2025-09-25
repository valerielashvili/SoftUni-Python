package p03_Wild_Farm;

class Mouse extends Mammal{

    Mouse(String animalName, double animalWeight, String livingRegion) throws IllegalArgumentException {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    protected String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    protected void eat(Food food, int foodQuantity) throws IllegalArgumentException {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        this.setFoodEaten(foodQuantity);
    }
}
