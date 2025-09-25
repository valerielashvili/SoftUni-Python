package p05_Pizza_Calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        Pizza pizza = new Pizza();

        while (!"END".equals(inputLine)) {
            String[] tokens = inputLine.split("\\s");

            try {
                if ("pizza".equalsIgnoreCase(tokens[0])) {
                    pizza = new Pizza(tokens[1], Integer.parseInt(tokens[2]));
                }
                if ("dough".equalsIgnoreCase(tokens[0])) {
                    Dough dough = new Dough(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
                    dough.calculateDoughCalories();
                    pizza.addCalories(dough.getDoughCalories());
                    if (pizza.getName() == null) {
                        System.out.printf("%.2f\n", dough.getDoughCalories());
                    }
                } else if ("topping".equalsIgnoreCase(tokens[0])) {
                    Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
                    topping.calculateToppingCalories();
                    if (pizza.getName() != null) {
                        pizza.addCalories(topping.getToppingCalories());
                    } else {
                        System.out.printf("%.2f\n", topping.getToppingCalories());
                    }
                }

                inputLine = reader.readLine();
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }
        }

        if (pizza.getName() != null && pizza.getTotalCalories() > 0) {
            System.out.println(pizza);
        }
    }
}
