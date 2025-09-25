import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_Mixed_Phones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Long> phoneRecords = new LinkedHashMap<>();

        String input = scanner.nextLine();

        long numberToAdd = 0;
        String key = "";

        while (!"Over".equals(input)) {
            String[] inputTokens = input.split(" : ");
            boolean isNumber = tokenIsNumber(inputTokens[0]);

            if (isNumber) {
                numberToAdd = Long.parseLong(inputTokens[0]);
                key = inputTokens[1];
            } else {
                numberToAdd = Long.parseLong(inputTokens[1]);
                key = inputTokens[0];
            }

            if (!phoneRecords.containsKey(key)) {
                phoneRecords.put(key, numberToAdd);
            }

            input = scanner.nextLine();
        }

        LinkedHashMap<String, Long> orderedMap = phoneRecords.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(String::compareTo))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, Long> entry : orderedMap.entrySet()) {
            String printKey = entry.getKey();
            String printValue = entry.getValue().toString();

            System.out.printf("%s -> %s\n", printKey, printValue
                    .replace("[", "").replace("]", ""));
        }
    }

    private static boolean tokenIsNumber(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
