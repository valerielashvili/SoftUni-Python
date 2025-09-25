package p05_Pizza_Calories;

import java.util.HashMap;
import java.util.Map;

class Dough {
    private static final double BASE_DOUGH_CALORIES = 2.0;

    private String flourType;
    private String bakingTechnique;
    private double weightInGrams;
    private Map<String, Double> doughModifiers;
    private double totalCalories;

    Dough(String flourType, String bakingTechnique, double weight) throws IllegalArgumentException {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
        this.doughModifiers = new HashMap<String, Double>() {{
            put("White", 1.5);
            put("Wholegrain", 1.0);
            put("Crispy", 0.9);
            put("Chewy", 1.1);
            put("Homemade", 1.0);
        }};
        this.calculateDoughCalories();
    }

    private void setFlourType(String flourType) throws IllegalArgumentException {
        if (!"white".equalsIgnoreCase(flourType) && !"wholegrain".equalsIgnoreCase(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) throws IllegalArgumentException {
        if (!"crispy".equalsIgnoreCase(bakingTechnique) && !"chewy".equalsIgnoreCase(bakingTechnique)
                && !"homemade".equalsIgnoreCase(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) throws IllegalArgumentException {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weightInGrams = weight;
    }

    void calculateDoughCalories() {
        this.totalCalories = (Dough.BASE_DOUGH_CALORIES * this.weightInGrams) *
                this.doughModifiers.get(this.flourType) * this.doughModifiers.get(this.bakingTechnique);
    }

    double getDoughCalories() {
        return this.totalCalories;
    }
}
