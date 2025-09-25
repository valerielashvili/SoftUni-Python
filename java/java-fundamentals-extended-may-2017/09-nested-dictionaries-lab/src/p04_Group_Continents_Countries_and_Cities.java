import java.util.*;
import java.util.stream.Collectors;

public class p04_Group_Continents_Countries_and_Cities {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeMap<String, TreeSet<String>>> continentsData = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine();
            String[] inputTokens = inputLine.split(" ");
            String continent = inputTokens[0];
            String country = inputTokens[1];
            String city = inputTokens[2];

            if (!continentsData.containsKey(continent)) {
                continentsData.put(continent, new TreeMap<>());
            }
            if (!continentsData.get(continent).containsKey(country)) {
                continentsData.get(continent).put(country, new TreeSet<>());
            }
            continentsData.get(continent).get(country).add(city);
        }

        for (Map.Entry<String, TreeMap<String, TreeSet<String>>> continentDataEntry :
                continentsData.entrySet()) {
            String continentName = continentDataEntry.getKey();
            TreeMap<String, TreeSet<String>> countryNameData = continentDataEntry.getValue();
            System.out.printf("%s:\n", continentName);

            for (Map.Entry<String, TreeSet<String>> countryNameDataEntry : countryNameData.entrySet()) {
                String countryName = countryNameDataEntry.getKey();
                TreeSet<String> cityNameData = countryNameDataEntry.getValue();
                String cityToPrint = cityNameData.stream().collect(Collectors.joining(", "));
                System.out.printf("  %s -> %s\n", countryName, cityToPrint);
            }
        }
    }
}
