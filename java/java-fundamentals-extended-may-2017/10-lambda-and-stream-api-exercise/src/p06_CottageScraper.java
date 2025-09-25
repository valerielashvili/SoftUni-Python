import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class p06_CottageScraper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, ArrayList<Double>> buildingMaterials = new LinkedHashMap<>();

        while (!"chop chop".equals(inputLine)) {
            String[] tokens = inputLine.split(" -> ");
            String tree = tokens[0];
            double length = Double.parseDouble(tokens[1]);

            if (!buildingMaterials.containsKey(tree)) {
                buildingMaterials.put(tree, new ArrayList<>());
            }
            buildingMaterials.get(tree).add(length);

            inputLine = scanner.nextLine();
        }

        String chosenTree = scanner.nextLine();
        double treeMinLength = Double.parseDouble(scanner.nextLine());

        // Round to 2nd decimal place
        double pricePerMeter = round(buildingMaterials.values().stream()
                .flatMapToDouble(v -> v.stream().mapToDouble(Double::valueOf)).average().getAsDouble(), 2);

        // Filtering only logs of chosen type of tree and minimum log length, which will be used in building.
        double usedLogsPrice = buildingMaterials.entrySet().stream()
                .filter(t -> t.getKey().equals(chosenTree))
                .flatMapToDouble(v -> v.getValue().stream()
                        .filter(h -> h >= treeMinLength).mapToDouble(l -> l * pricePerMeter)).sum();

        // Filtering unused logs, i.e. all other logs except the logs of chosen type and minimum length per log.
        double unusedLogsPrice = buildingMaterials.entrySet().stream()
                .filter(t -> !t.getKey().equals(chosenTree))
                .flatMapToDouble(v -> v.getValue().stream().mapToDouble(l -> (l * pricePerMeter) * 0.25)).sum()
                +
                buildingMaterials.entrySet().stream()
                .filter(t -> t.getKey().equals(chosenTree))
                .flatMapToDouble(v -> v.getValue().stream()
                        .filter(h -> h < treeMinLength).mapToDouble(l -> (l * pricePerMeter) * 0.25)).sum();

        double subTotal = usedLogsPrice + unusedLogsPrice;

        System.out.printf("Price per meter: $%.2f\n", pricePerMeter);
        System.out.printf("Used logs price: $%.2f\n", usedLogsPrice);
        System.out.printf("Unused logs price: $%.2f\n", unusedLogsPrice);
        System.out.printf("CottageScraper subtotal: $%.2f\n", subTotal);
    }
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
