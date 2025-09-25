import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p04_Most_Valued_Customer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        LinkedHashMap<String, Double> productsData = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Double>> customersData = new LinkedHashMap<>();

        String[] tokens;

        //Adding products and prices
        while (!"Shop is open".equals(inputLine)) {
            tokens = inputLine.split(" ");
            String productName = tokens[0];
            double price = Double.parseDouble(tokens[1]);

            if (!productsData.containsKey(productName)) {
                productsData.put(productName, price);
            }

            inputLine = scanner.nextLine();
        }

        inputLine = scanner.nextLine();

        //Adding customers, bought products and quantities
        while (!"Print".equals(inputLine)) {
            tokens = inputLine.split(": |, ");
            String customerName = tokens[0];
            double quantity = 1.0;

            if (!customersData.containsKey(customerName) && !"Discount".equals(inputLine)) {
                customersData.put(customerName, new LinkedHashMap<>());
            }

            for (int i = 1; i < tokens.length; i++) {
                if (!customersData.get(customerName).containsKey(tokens[i])) {
                    customersData.get(customerName).put(tokens[i], quantity);
                } else {
                    quantity = customersData.get(customerName).get(tokens[i]);
                    customersData.get(customerName).put(tokens[i], quantity + 1.0);
                }
            }

            if ("Discount".equals(inputLine)) {
                productsData.entrySet().stream()
                        .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                        .limit(3)
                        .forEach(p -> {
                            productsData.put(p.getKey(), productsData.get(p.getKey()) * 0.9);
                        });
            }

            inputLine = scanner.nextLine();
        }
        // Counting how much a customer spent on a product
        customersData.entrySet().forEach(c -> c.getValue().entrySet()
                .forEach(p -> {
                    double spentOnProduct = p.getValue() * productsData.get(p.getKey());
                    customersData.get(c.getKey()).put(p.getKey(), spentOnProduct);
                }));

        // Counting every customer's total spent
        customersData.entrySet().stream().forEach(c -> {
            double totalSpent = c.getValue().entrySet().stream().mapToDouble(p -> p.getValue()).sum();
            customersData.get(c.getKey()).put("Total", totalSpent);
        });

        // Changing product's value from the customer's spent money to a discounted product price
        customersData.entrySet().forEach(c -> c.getValue().entrySet()
                .forEach(p -> {
                    if (productsData.containsKey(p.getKey())) {
                        customersData.get(c.getKey()).put(p.getKey(), productsData.get(p.getKey()));
                    }
                }));

        // Printing data using lambda only
        customersData.entrySet().stream()
                .sorted((a, b) -> {
                    double aTotal = customersData.get(a.getKey()).get("Total");
                    double bTotal = customersData.get(b.getKey()).get("Total");
                    return Double.compare(bTotal, aTotal);
                })
                .limit(1)
                .forEach(c -> {
                    System.out.printf("Biggest spender: %s\n", c.getKey());
                    System.out.println("^Products bought:");

                    c.getValue().entrySet().stream()
                            .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                            .filter(e -> !e.getKey().equals("Total"))
                            .forEach(pr -> System.out.printf("^^^%s: %.2f\n", pr.getKey(), pr.getValue()));

                    System.out.printf("Total: %s",
                            c.getValue().entrySet().stream()
                                    .filter(e -> e.getKey().equals("Total"))
                                    .map(v -> String.format("%.2f", v.getValue()))
                                    .collect(Collectors.joining("")));
                });
    }
}
