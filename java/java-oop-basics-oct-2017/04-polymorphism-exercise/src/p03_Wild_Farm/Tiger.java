package p03_Wild_Farm;

class Tiger extends Felime{
    private String livingRegion;

    Tiger(String animalName, double animalWeight, String livingRegion) throws IllegalArgumentException {
        super(animalName, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }

    @Override
    protected String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    protected void eat(Food food, int foodQuantity) throws IllegalArgumentException {
        if (!food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        this.setFoodEaten(foodQuantity);
    }
}
