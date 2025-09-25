package p04_Shopping_Spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] peopleInput = Arrays.stream(reader.readLine().split("[=;]")).toArray(String[]::new);
        String[] productsInput = Arrays.stream(reader.readLine().split("[=;]")).toArray(String[]::new);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        for (int i = 0; i < peopleInput.length - 1; i += 2) {
            String name = peopleInput[i];
            double amount = Double.parseDouble(peopleInput[i + 1]);
            try {
                Person person = new Person(name, amount);
                people.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        for (int i = 0; i < productsInput.length - 1; i += 2) {
            String name = productsInput[i];
            int cost = Integer.parseInt(productsInput[i + 1]);
            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String inputLine = reader.readLine();

        while (!"END".equals(inputLine) && people.size() != 0 && products.size() != 0) {
            String[] tokens = inputLine.split("\\s+");

            if (people.get(tokens[0]).hasMoney(products.get(tokens[1]))) {
                people.get(tokens[0]).charge(products.get(tokens[1]).getCost());
                people.get(tokens[0]).addProduct(products.get(tokens[1]));
                System.out.printf("%s bought %s\n", people.get(tokens[0]).getName(), products.get(tokens[1]).getName());
            } else {
                System.out.printf("%s can't afford %s\n", people.get(tokens[0]).getName(), products.get(tokens[1]).getName());
            }
            inputLine = reader.readLine();
        }
        people.forEach((key, value) -> System.out.println(value));
    }
}
