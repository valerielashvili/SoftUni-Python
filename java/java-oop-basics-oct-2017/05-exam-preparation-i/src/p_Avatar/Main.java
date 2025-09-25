package p_Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        StringBuilder result = new StringBuilder();
        StringBuilder warsHistory = new StringBuilder();
        int warCounter = 1;

        while (!"Quit".equals(inputLine)) {
            String[] tokens = inputLine.split(" ");

            if ("Bender".equals(tokens[0])) {
                Factory.createBender(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4]));
            } else if ("Monument".equals(tokens[0])) {
                Factory.createMonument(tokens[1], tokens[2], Integer.parseInt(tokens[3]));
            } else if ("Status".equals(tokens[0])) {
                result.append(Controller.getStatus(tokens[1]));
            } else if ("War".equals(tokens[0])) {
                warsHistory.append(String.format("War %d issued by %s\n", warCounter++, tokens[1]));
                Controller.beginWar();
            }

            inputLine = reader.readLine();
        }

        System.out.print(result);
        System.out.println(warsHistory);
    }
}
