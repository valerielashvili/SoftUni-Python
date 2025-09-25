import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p01_Wardrobe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String input = "";
        String[] tokens;

        LinkedHashMap<String, LinkedHashMap<String, Integer>> wardrobe = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            input = scanner.nextLine();
            tokens = input.split(" -> |,");
            String color = tokens[0];

            if (!wardrobe.containsKey(color)) {
                wardrobe.put(color, new LinkedHashMap<>());
            }

            // Checking if a cloth already exists, adding it and counting occurrences
            for (int j = 1; j < tokens.length; j++) {
                if (!wardrobe.get(color).containsKey(tokens[j])) {
                    wardrobe.get(color).put(tokens[j], 0);
                }

                int counter = wardrobe.get(color).get(tokens[j]);
                wardrobe.get(color).put(tokens[j], counter + 1);
            }
        }

        input = scanner.nextLine();
        tokens = input.split(" ");

        for (Map.Entry<String, LinkedHashMap<String, Integer>> wardrobeEntry : wardrobe.entrySet()) {
            String colorName = wardrobeEntry.getKey();
            LinkedHashMap<String, Integer> clothesData = wardrobeEntry.getValue();

            System.out.printf("%s clothes:\n", colorName);

            for (Map.Entry<String, Integer> clothesDataEntry : clothesData.entrySet()) {
                String clothName = clothesDataEntry.getKey();
                int occurrences = clothesDataEntry.getValue();

                if (wardrobeEntry.getKey().contains(tokens[0]) && tokens[1].equals(clothName)) {
                    System.out.printf("* %s - %s (found!)\n", clothName, occurrences);
                } else {
                    System.out.printf("* %s - %s\n", clothName, occurrences);
                }
            }
        }
    }
}
