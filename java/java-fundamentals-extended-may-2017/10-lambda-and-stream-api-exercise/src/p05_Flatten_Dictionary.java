import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p05_Flatten_Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, String>> keyValuesData = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> flattenedRecords = new LinkedHashMap<>();

        while (!"end".equals(inputLine)) {
            String[] tokens = inputLine.split(" ");
            String key = tokens[0];
            String flattenKey = "";

            if (!"flatten".equals(key)) {
                String innerKey = tokens[1];
                String innerValue = tokens[2];

                if (!keyValuesData.containsKey(key)) {
                    keyValuesData.put(key, new LinkedHashMap<>());
                }
                if (!keyValuesData.get(key).containsKey(innerKey)) {
                    keyValuesData.get(key).put(innerKey, "");
                }
                keyValuesData.get(key).put(innerKey, innerValue);
            } else {
                flattenKey = tokens[1];

                if (!flattenedRecords.containsKey(flattenKey)) {
                    flattenedRecords.put(flattenKey, new ArrayList<>());
                }
                for (Map.Entry<String, LinkedHashMap<String, String>> keyValuesEntry :
                        keyValuesData.entrySet()) {

                    String keyToFlat = keyValuesEntry.getKey();
                    LinkedHashMap<String, String> innerRecords = keyValuesEntry.getValue();

                    if (flattenKey.equals(keyToFlat)) {
                        for (Map.Entry<String, String> innerRecord : innerRecords.entrySet()) {

                            String flattenedKeyValue = innerRecord.getKey() + innerRecord.getValue();
                            flattenedRecords.get(flattenKey).add(flattenedKeyValue);
                        }
                    }
                }
                keyValuesData.put(flattenKey, new LinkedHashMap<>());
            }
            inputLine = scanner.nextLine();
        }

        // Sorting keyValuesData by keys in descending order.
        LinkedHashMap<String, LinkedHashMap<String, String>> orderedKeyValues = keyValuesData.entrySet().stream()
                .sorted((k1, k2) -> k2.getKey().length() - k1.getKey().length())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, LinkedHashMap<String, String>> orderedKeyValuesEntry : orderedKeyValues.entrySet()) {
            String key = orderedKeyValuesEntry.getKey();

            System.out.printf("%s\n", key);

            // Sorting inner records by keys in ascending order.
            LinkedHashMap<String, String> orderedInnerRecords = orderedKeyValuesEntry.getValue().entrySet().stream()
                    .sorted((k1, k2) -> k1.getKey().length() - k2.getKey().length())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

            int orderId = 1;
            for (Map.Entry<String, String> innerRecord : orderedInnerRecords.entrySet()) {
                String innerKey = innerRecord.getKey();
                String innerValue = innerRecord.getValue();

                System.out.printf("%d. %s - %s\n", orderId, innerKey, innerValue);

                orderId++;
            }
            if (flattenedRecords.containsKey(key)) {
                for (String flattenKeyValue : flattenedRecords.get(key)) {
                    System.out.printf("%d. %s\n", orderId, flattenKeyValue);
                    orderId++;
                }
            }
        }
    }
}
