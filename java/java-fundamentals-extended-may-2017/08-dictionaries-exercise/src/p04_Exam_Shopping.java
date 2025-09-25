import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p04_Exam_Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> products = new LinkedHashMap<>();

        String inputLine = scanner.nextLine();

        String[] inputTokens;
        String command = "";
        String productName = "";
        int quantity = 0;

        while (!"exam time".equals(inputLine)) {

                inputTokens = inputLine.split(" ");
                command = inputTokens[0];
                productName = inputTokens[1];
                quantity = Integer.parseInt(inputTokens[2]);

                if ("stock".equals(command)) {
                    if (!products.containsKey(productName)) {
                        products.put(productName, 0);
                    }
                    products.put(productName, products.get(productName) + quantity);
                } else if ("buy".equals(command)) {

                    if (!products.containsKey(productName)) {
                        System.out.printf("%s doesn't exist%n", productName);
                    } else {
                        if (products.get(productName) > 0) {
                            products.put(productName, products.get(productName) - quantity);
                        } else if (products.get(productName) <= 0) {
                            products.put(productName, 0);
                            System.out.printf("%s out of stock%n", productName);
                        }
                    }
                }

            inputLine = scanner.nextLine();

            if ("shopping time".equals(inputLine)) {
                inputLine = scanner.nextLine();
            }
        }

        LinkedHashMap<String, Integer> filteredMap = products.entrySet().stream()
                .filter(a -> a.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, Integer> entry : filteredMap.entrySet()) {
            String printKey = entry.getKey();
            Integer printValue = entry.getValue();

            System.out.printf("%s -> %d%n", printKey, printValue);
        }
    }
}
