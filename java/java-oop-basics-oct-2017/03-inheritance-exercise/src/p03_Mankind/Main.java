package p03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] tokens = reader.readLine().split("\\s+");
            Human student = new Student(tokens[0], tokens[1], tokens[2]);

            tokens = reader.readLine().split("\\s+");
            Human worker = new Worker(tokens[0], tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
