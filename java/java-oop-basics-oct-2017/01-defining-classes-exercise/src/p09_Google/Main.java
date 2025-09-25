package p09_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        Map<String, Person> people = new HashMap<>();

        while (!"End".equals(inputLine)) {
            String[] tokens = inputLine.split("\\s+");
            String name = tokens[0];
            String attribute = tokens[1];
            Person person = new Person(name);
            people.putIfAbsent(name, person);

            if ("company".equals(attribute)) {
                people.get(name).setCompany(tokens[2]);
                people.get(name).setDepartment(tokens[3]);
                people.get(name).setSalary(Double.parseDouble(tokens[4]));
            } else if ("pokemon".equals(attribute)) {
                Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                people.get(name).addPokemon(pokemon);
            } else if ("parents".equals(attribute)) {
                Parent parent = new Parent(tokens[2], tokens[3]);
                people.get(name).addParent(parent);
            } else if ("children".equals(attribute)) {
                Child child = new Child(tokens[2], tokens[3]);
                people.get(name).addChild(child);
            } else if ("car".equals(attribute)) {
                Car car = new Car(tokens[2], Integer.parseInt(tokens[3]));
                people.get(name).setCar(car);
            }
            inputLine = reader.readLine();
        }
        inputLine = reader.readLine();

        String finalName = inputLine;
        people.values()
                .stream()
                .filter(e -> e.getName().equals(finalName))
                .forEach(Person::print);
    }
}
