package p06_Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String animalType = reader.readLine();

        while (!"Beast!".equals(animalType)) {
            String[] tokens = reader.readLine().split("\\s+");
            try {
                Animal animal = createAnimal(animalType, tokens);
                if (animal == null) {
                    System.out.println(ErrorMessageConstants.INVALID_INPUT_MESSAGE);
                } else {
                    System.out.println(animal);
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            animalType = reader.readLine();
        }
    }

    private static Animal createAnimal(String animalType, String[] tokens) {
        if ("Animal".equals(animalType)) {
            return new Animal(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
        } else if ("Dog".equals(animalType)) {
            return new Dog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
        } else if ("Frog".equals(animalType)) {
            return new Frog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
        } else if ("Cat".equals(animalType)) {
            return new Cat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
        } else if ("Kitten".equals(animalType)) {
            return new Kitten(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
        } else if ("Tomcat".equals(animalType)) {
            return new Tomcat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
        }
        return null;
    }
}
