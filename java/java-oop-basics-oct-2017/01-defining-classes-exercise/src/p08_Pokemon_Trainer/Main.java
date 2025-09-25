package p08_Pokemon_Trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        HashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (!"Tournament".equals(inputLine)) {
            String[] tokens = inputLine.split("\\s+");
            Trainer trainer = new Trainer(tokens[0]);
            Pokemon pokemon = new Pokemon(tokens[1], tokens[2], Integer.parseInt(tokens[3]));
            trainer.addPokemon(pokemon);

            if (trainers.containsKey(tokens[0])) {
                trainers.get(tokens[0]).addPokemon(pokemon);
            } else {
                trainers.put(tokens[0], trainer);
            }
            inputLine = reader.readLine();
        }
        inputLine = reader.readLine();

        while (!"End".equals(inputLine)) {
            for (String name : trainers.keySet()) {
                trainers.get(name).checkForElement(inputLine);
            }
            inputLine = reader.readLine();
        }

        trainers.values()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .forEach(System.out::println);
    }
}
