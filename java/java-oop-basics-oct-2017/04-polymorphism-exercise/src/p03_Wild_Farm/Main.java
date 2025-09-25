package p03_Wild_Farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String PATTERN = "#.##";
    static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(PATTERN);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        List<Animal> animals = new ArrayList<>();

        while (!"End".equals(inputLine)) {
            Animal animal = createAnimal(inputLine);

            String foodInput = reader.readLine();
            Food food = createFood(foodInput);

            System.out.println(animal.makeSound());

            try {
                animal.eat(food, food.getQuantity());
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            animals.add(animal);

            inputLine = reader.readLine();
        }
        animals.forEach(System.out::println);
    }

    private static Food createFood(String foodInput) {
        String[] tokens = foodInput.split("\\s+");
        if ("Vegetable".equals(tokens[0])) {
            return new Vegetable(Integer.parseInt(tokens[1]));
        } else if ("Meat".equals(tokens[0])) {
            return new Meat(Integer.parseInt(tokens[1]));
        }
        return null;
    }

    private static Animal createAnimal(String input) {
        String[] tokens = input.split("\\s+");
        if ("Cat".equals(tokens[0])) {
            return new Cat(tokens[1], Double.parseDouble(tokens[2]), tokens[3], tokens[4]);
        } else if ("Tiger".equals(tokens[0])) {
            return new Tiger(tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
        } else if ("Zebra".equals(tokens[0])) {
            return new Zebra(tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
        } else if ("Mouse".equals(tokens[0])) {
            return new Mouse(tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
        }
        return null;
    }
}
