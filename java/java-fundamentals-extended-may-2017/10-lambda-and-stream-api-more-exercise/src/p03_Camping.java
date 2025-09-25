import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_Camping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, Integer>> campersData = new LinkedHashMap<>();

        while (!"end".equals(inputLine)) {
            String[] tokens = inputLine.split(" ");
            String name = tokens[0];
            String camper = tokens[1];
            int nights = Integer.parseInt(tokens[2]);

            if (!campersData.containsKey(name)) {
                campersData.put(name, new LinkedHashMap<>());
            }
            campersData.get(name).put(camper, nights);

            inputLine = scanner.nextLine();
        }

        // Ordering people by the campers count, in case of two people have an equal number of campers,
        // ordering them by their name length.
        campersData.entrySet().stream().sorted((a, b) -> {
            int campersCount = b.getValue().values().size() - a.getValue().values().size();
            int nameLength = a.getKey().length() - b.getKey().length();
            if (campersCount == 0) {
                return nameLength;
            } else {
                return campersCount;
            }
        }).forEach(c -> {
            System.out.printf("%s: %d\n", c.getKey(), c.getValue().size());
            System.out.printf("***%s\n", c.getValue().keySet().stream().collect(Collectors.joining("\n***")));
            System.out.printf("Total stay: %d nights\n", c.getValue().values().stream()
                    .mapToInt(Integer::valueOf).sum());
        });
    }
}
