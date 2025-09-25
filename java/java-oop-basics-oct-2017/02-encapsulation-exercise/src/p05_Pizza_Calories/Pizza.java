package p05_Pizza_Calories;

class Pizza {
    private String name;
    private int numberOfToppings;
    private double totalCalories;

    Pizza() {
        this.numberOfToppings = 0;
        this.totalCalories = 0.0;
    }

    Pizza(String name, int numberOfToppings) throws IllegalArgumentException {
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.totalCalories = 0.0;
    }

    private void setName(String name) throws IllegalArgumentException {
        if (name.length() == 0 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setNumberOfToppings(int numberOfToppings) throws IllegalArgumentException {
        if (numberOfToppings < 1 || numberOfToppings > 15){
            throw  new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    void addCalories(double calories) {
        this.totalCalories += calories;
    }

    String getName() {
        return this.name;
    }

    double getTotalCalories() {
        return  this.totalCalories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.totalCalories);
    }
}
