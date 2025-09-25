package p03_Wild_Farm;

import static p03_Wild_Farm.Main.DECIMAL_FORMAT;

class Cat extends Felime{
    private String breed;

    Cat(String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    protected String makeSound() {
        return "Meowwww";
    }

    @Override
    protected void eat(Food food, int foodQuantity) {
        this.setFoodEaten(foodQuantity);
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]", this.getClass().getSimpleName(), super.getAnimalName(),
                this.breed, DECIMAL_FORMAT.format(super.getAnimalWeight()), super.getLivingRegion(), super.getFoodEaten());
    }
}
