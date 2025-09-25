import java.util.*;

public class p12_To_the_Stars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, ArrayList<Double>> starSystems = new LinkedHashMap<>();

        for (int i = 0; i < 3; i++) {
            String[] star = scanner.nextLine().split("\\s+");
            starSystems.put(star[0], new ArrayList<>());
            starSystems.get(star[0]).add(Double.parseDouble(star[1]));
            starSystems.get(star[0]).add(Double.parseDouble(star[2]));
        }
        double[] shipsCoordinates = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToDouble(Double::parseDouble).toArray();
        int n = Integer.parseInt(scanner.nextLine());

        navigateThePath(starSystems, shipsCoordinates, n);
    }

    private static void navigateThePath(LinkedHashMap<String, ArrayList<Double>> starSystems, double[] pos, int n) {
        double shipX = pos[0];
        double shipY = pos[1];
        for (int i = 0; i <= n; i++) {
            String currentLocation = "space";
            for (Map.Entry<String, ArrayList<Double>> star : starSystems.entrySet()) {
                double leftSide = star.getValue().get(0) - 1;
                double rightSide = star.getValue().get(0) + 1;
                double downBorder = star.getValue().get(1) - 1;
                double upperBorder = star.getValue().get(1) + 1;

                if (shipX >= leftSide && shipY >= downBorder && shipX <= rightSide && shipY <= upperBorder) {
                    currentLocation = star.getKey();
                }
            }
            System.out.println(currentLocation.toLowerCase());
            shipY++;
        }
    }
}
