package p03_Validation_Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> persons = new ArrayList<>();

        while (n-- > 0) {
            try {
                String[] input = reader.readLine().split(" ");
                persons.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        int bonus = Integer.parseInt(reader.readLine());
        persons.forEach(p -> p.increaseSalary(bonus));

        persons.forEach(System.out::println);
    }
}
