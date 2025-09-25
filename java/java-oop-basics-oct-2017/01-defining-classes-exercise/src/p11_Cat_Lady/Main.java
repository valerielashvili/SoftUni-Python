package p11_Cat_Lady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        HashMap<String, Cat> cats = new HashMap<>();

        Cat cat = null;
        while (!"End".equals(inputLine)) {
            String[] tokens = inputLine.split("\\s+");

            if ("Siamese".equals(tokens[0])) {
                cat = new Siamese(tokens[1], Double.parseDouble(tokens[2]));
                cats.putIfAbsent(tokens[1], cat);
            } else if ("Cymric".equals(tokens[0])) {
                cat = new Cymric(tokens[1], Double.parseDouble(tokens[2]));
                cats.putIfAbsent(tokens[1], cat);
            } else if ("StreetExtraordinaire".equals(tokens[0])) {
                cat = new StreetExtraordinaire(tokens[1], Double.parseDouble(tokens[2]));
                cats.putIfAbsent(tokens[1], cat);
            }
            inputLine = reader.readLine();
        }

        System.out.println(cats.get(reader.readLine()));
    }
}
