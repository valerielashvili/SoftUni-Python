package p10_Family_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String startingValue = reader.readLine();

        List<String> parentChildrenCouples = new ArrayList<>();
        List<Person> people = new ArrayList<>();

        String inputLine = reader.readLine();

        while (!"End".equals(inputLine)) {
            if (inputLine.contains("-")) {
                parentChildrenCouples.add(inputLine);
            } else {
                String[] tokens = inputLine.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                Person tmpPerson = new Person(name, tokens[2]);
                people.add(tmpPerson);
            }
            inputLine = reader.readLine();
        }

        Person person = people
                .stream()
                .filter(p -> p.getName().equals(startingValue) || p.getBirthDate().equals(startingValue))
                .findFirst()
                .orElse(null);

        List<String> parents = new ArrayList<>();
        List<String> children = new ArrayList<>();

        //Checking for the main person's parents and children
        for (String couple : parentChildrenCouples) {
            String[] coupleTokens = couple.split(" - ");
            String parent = coupleTokens[0];
            String child = coupleTokens[1];

            if (parent.equals(person.getBirthDate()) || parent.equals(person.getName())) {
                children.add(child);
            } else if (child.equals(person.getBirthDate()) || child.equals(person.getName())) {
                parents.add(parent);
            }
        }

        StringBuilder sb = new StringBuilder(person.toString()).append(System.lineSeparator());
        sb.append("Parents:").append(System.lineSeparator());
        for (String parent : parents) {
            sb.append(people.stream()
                    .filter(p -> p.getName().equals(parent) || p.getBirthDate().equals(parent))
                    .findFirst()
                    .orElse(null)).append(System.lineSeparator());
        }
        sb.append("Children:").append(System.lineSeparator());
        for (String child : children) {
            sb.append(people.stream()
                    .filter(p -> p.getName().equals(child) || p.getBirthDate().equals(child))
                    .findFirst()
                    .orElse(null)).append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}
