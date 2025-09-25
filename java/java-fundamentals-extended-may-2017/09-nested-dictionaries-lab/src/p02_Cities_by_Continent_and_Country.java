import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_Cities_by_Continent_and_Country {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // Creating new LinkedHashMap(Dictionary) for purposes of the program
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continentsData = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            // Reading data from the console, splitting it and allocating to variables
            String inputLine = scanner.nextLine();
            String[] inputTokens = inputLine.split(" ");
            String continent = inputTokens[0];
            String country = inputTokens[1];
            String city = inputTokens[2];
            
            // Checking if a continent already exists and adding it
            if (!continentsData.containsKey(continent)) {
                continentsData.put(continent, new LinkedHashMap<>());
            }
            // Checking if a country already exists and adding it
            if (!continentsData.get(continent).containsKey(country)) {
                continentsData.get(continent).put(country, new ArrayList<>());
            }
            // Adding a city to the countryMap's ArrayLis according to the continent
            continentsData.get(continent).get(country).add(city);
        }
        
        // Iterating through the continentDataEntrySet and reading stored data
        for (Map.Entry<String, LinkedHashMap<String, ArrayList<String>>> continentsDataEntry :
                continentsData.entrySet()) {

            String continentName = continentsDataEntry.getKey();
            // Creating new LinkedHashMap for storing countryNameDataEntrySet and reading it later
            LinkedHashMap<String, ArrayList<String>> countryNameData = continentsDataEntry.getValue();

            System.out.printf("%s: \n", continentName);
            
            // Iterating through the countryNameDataEntrySet and reading stored data
            for (Map.Entry<String, ArrayList<String>> countryNameEntry : countryNameData.entrySet()) {
                String countryName = countryNameEntry.getKey();
                ArrayList<String> cityNameData = countryNameEntry.getValue();
                String cityToPrint = cityNameData.stream().collect(Collectors.joining(", "));
                System.out.printf("  %s -> %s\n", countryName, cityToPrint);
            }
        }
    }
}
