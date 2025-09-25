package p04_Mordors_Cruelty_Plan;

abstract class FoodFactory {
    private int happinessPoints;

    int getHappinessPoints() {
        return this.happinessPoints;
    }

    void eatFood(String food) {
        food = food.toLowerCase();

        if ("cram".equals(food)) {
            this.happinessPoints += 2;
        } else if ("lembas".equals(food)) {
            this.happinessPoints += 3;
        } else if ("apple".equals(food)) {
            this.happinessPoints += 1;
        } else if ("melon".equals(food)) {
            this.happinessPoints += 1;
        } else if ("honeycake".equals(food)) {
            this.happinessPoints += 5;
        } else if ("mushrooms".equals(food)) {
            this.happinessPoints -= 10;
        } else {
            this.happinessPoints -= 1;
        }
    }
}
