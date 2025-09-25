import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p04_CODE_Phoenix_Oscar_Romeo_November {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, ArrayList<String>> creatures = new LinkedHashMap<>();

        while (!"Blaze it!".equals(inputLine)) {
            String[] tokens = inputLine.split(" -> ");
            String creature = tokens[0];
            String squadMate = tokens[1];

            creatures.putIfAbsent(creature, new ArrayList<>());
            if (!creatures.get(creature).contains(squadMate) && !creatures.get(creature).equals(squadMate)) {
                creatures.get(creature).add(squadMate);
            }
            inputLine = scanner.nextLine();
        }

        LinkedHashMap<String, ArrayList<String>> resultCreatures = new LinkedHashMap<>();

        for (Map.Entry<String, ArrayList<String>> creaturesEntry : creatures.entrySet()) {
            ArrayList<String> squadMates = creaturesEntry.getValue();
            String creature = creaturesEntry.getKey();

            for (int i = 0; i < squadMates.size(); i++) {
                if (squadMates.get(i).equals(creature) && creaturesEntry.getValue().contains(creature)) {
                    squadMates.remove(creature);
                }
            }



            resultCreatures.put(creature, squadMates);
        }

        resultCreatures.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int aCount = a.getValue().size();
                    int bCount = b.getValue().size();
                    return Integer.compare(bCount, aCount);
                })
                .forEach(creature -> {
                    System.out.printf("%s : ", creature.getKey());
                    int squadMates = creature.getValue().size();
                    System.out.printf("%s%n", squadMates);
                });
    }
}
