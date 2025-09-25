import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p02_Dict_Ref {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> refDictionary = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] inputTokens = input.split(" = ");
            boolean isInteger = valueIsInteger(inputTokens[1]);

            if (isInteger) {
                if (!refDictionary.containsKey(inputTokens[0])) {
                    refDictionary.put(inputTokens[0], 0);
                }
                int numberToAdd = Integer.parseInt(inputTokens[1]);
                refDictionary.put(inputTokens[0], numberToAdd);
            } else {
                if (refDictionary.containsKey(inputTokens[1])) {
                    refDictionary.put(inputTokens[0], refDictionary.get(inputTokens[1]));
                }
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : refDictionary.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();

            System.out.printf("%s === %s\n", key, value
                    .replace("[", "").replace("]", ""));
        }
    }

    private static boolean valueIsInteger(String valueInput) {
        for (int i = 0; i < valueInput.length(); i++) {
            if (!Character.isDigit(valueInput.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
