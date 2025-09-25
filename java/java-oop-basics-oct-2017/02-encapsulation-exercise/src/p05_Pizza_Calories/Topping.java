package p05_Pizza_Calories;

import java.util.HashMap;
import java.util.Map;

class Topping {
    private static final double BASE_TOPPING_CALORIES = 2.0;

    private String name;
    private double weightInGrams;
    private Map<String, Double> toppingModifiers;
    private double totalCalories;

    Topping(String name, double weight) throws IllegalArgumentException {
        this.setName(name);
        this.setWeight(weight);
        this.toppingModifiers = new HashMap<String, Double>() {{
            put("Meat", 1.2);
            put("Veggies", 0.8);
            put("Cheese", 1.1);
            put("Sauce", 0.9);
        }};
        this.calculateToppingCalories();
    }

    private void setName(String name) throws IllegalArgumentException {
        if (!"meat".equalsIgnoreCase(name) && !"veggies".equalsIgnoreCase(name) && !"cheese".equalsIgnoreCase(name)
                && !"sauce".equalsIgnoreCase(name)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", name));
        }
        this.name = name;
    }

    private void setWeight(double weight) throws IllegalArgumentException {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.name));
        }
        this.weightInGrams = weight;
    }

    void calculateToppingCalories() {
        this.totalCalories = (Topping.BASE_TOPPING_CALORIES * this.weightInGrams) * this.toppingModifiers.get(this.name);
    }

    double getToppingCalories() {
        return this.totalCalories;
    }
}
