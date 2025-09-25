import java.util.LinkedHashMap;
import java.util.Scanner;

public class p03_Travel_Company {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Integer>> travelData = new LinkedHashMap<>();

        String[] tokens;
        String city = "";
        int capacity = 0;

        while (!"ready".equals(inputLine)) {
            tokens = inputLine.split(":|-|,");
            city = tokens[0];

            if (!travelData.containsKey(city)) {
                travelData.put(city, new LinkedHashMap<>());
            }
            for (int i = 1; i < tokens.length; i += 2) {
                if (!travelData.get(city).containsKey(tokens[i])) {
                    travelData.get(city).put(tokens[i], 0);
                }
                capacity = Integer.parseInt(tokens[i + 1]);
                travelData.get(city).put(tokens[i], capacity);
            }
            inputLine = scanner.nextLine();
        }

        inputLine = scanner.nextLine();
        int touristsNumber = 0;
        int totalCapacity = 0;

        while (!"travel time!".equals(inputLine)) {
            tokens = inputLine.split(" ");
            city = tokens[0];
            touristsNumber = Integer.parseInt(tokens[1]);

            if (travelData.keySet().contains(city)) {
                totalCapacity = travelData.get(city).values().stream().mapToInt(i -> i.intValue()).sum();

                if (totalCapacity >= touristsNumber) {
                    System.out.printf("%s -> all %d accommodated\n", city, touristsNumber);
                } else {
                    touristsNumber -= totalCapacity;
                    System.out.printf("%s -> all except %d accommodated\n", city, touristsNumber);
                }
            }
            inputLine = scanner.nextLine();
        }
    }
}