import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_Grocery_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, Double> productsData = new LinkedHashMap<>();


        while (!"bill".equals(inputLine)) {
            Pattern pattern = Pattern.compile("^[A-Z][a-z]+:\\d+\\.\\d{2}$");
            Matcher matcher = pattern.matcher(inputLine);

            while (matcher.find()) {
                String[] tokens = inputLine.split(":");
                productsData.put(tokens[0], Double.parseDouble(tokens[1]));
            }

            inputLine = scanner.nextLine();
        }

        productsData.entrySet()
                .stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .forEach(p -> System.out.printf("%s costs %.2f\n", p.getKey(), p.getValue()));
    }
}
