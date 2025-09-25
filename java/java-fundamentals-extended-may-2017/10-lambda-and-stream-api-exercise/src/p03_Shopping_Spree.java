import java.util.LinkedHashMap;
import java.util.Scanner;

public class p03_Shopping_Spree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, Double> productsData = new LinkedHashMap<>();

        while (!"end".equals(inputLine)) {
            String[] tokens = inputLine.split(" ");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);

            if (!productsData.containsKey(product)) {
                productsData.put(product, price);
            } else if (price < productsData.get(product)) {
                productsData.put(product, price);
            }

            inputLine = scanner.nextLine();
        }

        double productsSum = productsData.values().stream().mapToDouble(Double::valueOf).sum();

        if (productsSum > budget) {
            System.out.println("Need more money... Just buy banichka");
        } else {
            productsData.entrySet().stream().sorted((a, b) -> {
                int priceOrderDesc = b.getValue().compareTo(a.getValue());
                int charCountAscend = a.getKey().chars().sum() - b.getKey().chars().sum();

                if (priceOrderDesc != 0) {
                    return priceOrderDesc;
                } else if (charCountAscend != 1) {
                    return charCountAscend;
                }
                return 1;
            }).forEach(a -> System.out.printf("%s costs %.2f\n", a.getKey(), a.getValue()));
        }
    }
}
