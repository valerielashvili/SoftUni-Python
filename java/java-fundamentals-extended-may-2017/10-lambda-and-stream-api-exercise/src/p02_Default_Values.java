import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_Default_Values {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, String> keyValuePairs = new LinkedHashMap<>();

        while (!"end".equals(inputLine)) {
            String[] tokens = inputLine.split(" -> ");
            String key = tokens[0];
            String value = tokens[1];

            keyValuePairs.put(key, value);

            inputLine = scanner.nextLine();
        }

        inputLine = scanner.nextLine();

        for (Map.Entry<String, String> orderedByValue : keyValuePairs.entrySet()) {
            String key = orderedByValue.getKey();
            String value = orderedByValue.getValue();
            if ("null".equals(value)) {
                keyValuePairs.put(key, inputLine);
            }
        }

        String finalInputLine = inputLine;

        // TODO: Write mapping for nonDefaultValues
        // new LinkedHashMap<>(...).collect(Collectors.toMap(a -> a.getKey(), a -> a.getValue())));
        // is absolutely wrong collecting and mapping in case of the exercises, because this way of collecting
        // doesn't guarantee preserving of order input from the previous LinkedHashMap
        LinkedHashMap<String, String> nonDefaultValues = keyValuePairs.entrySet().stream()
                .sorted((a, b) -> b.getValue().length() - a.getValue().length())
                .filter(a -> !a.getValue().equals(finalInputLine))
                .collect(Collectors.toMap(Map.Entry::getKey , Map.Entry::getValue, (a,b) -> a, LinkedHashMap::new));

        LinkedHashMap<String, String> defaultValues = keyValuePairs.entrySet().stream()
                .sorted((a, b) -> a.getValue().compareTo(b.getValue()))
                .filter(a -> a.getValue().equals(finalInputLine))
                .collect(Collectors.toMap(Map.Entry::getKey , Map.Entry::getValue, (a,b) -> a, LinkedHashMap::new));

        for (Map.Entry<String,String> keyValuesOrdered : nonDefaultValues.entrySet()) {
            String key = keyValuesOrdered.getKey();
            String value = keyValuesOrdered.getValue();

            System.out.printf("%s <-> %s\n", key, value);
        }

        for (Map.Entry<String,String> defaultValuesEntry : defaultValues.entrySet()) {
            String key = defaultValuesEntry.getKey();
            String value = defaultValuesEntry.getValue();

            System.out.printf("%s <-> %s\n", key, value);
        }
    }
}
