import java.util.Scanner;

public class p05_Transport_Price {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int distance = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double initialTax = 0.7;
        double priceOfTheTrip = 0.0;

        if (distance < 20) {
            if ("day".equals(timeOfDay)) {
                priceOfTheTrip = distance * 0.79 + initialTax;
            } else {
                priceOfTheTrip = distance * 0.9 + initialTax;
            }
        } else if (distance >= 20 && distance < 100) {
            priceOfTheTrip = distance * 0.09;
        } else {
            priceOfTheTrip = distance * 0.06;
        }

        System.out.printf("%.2f", priceOfTheTrip);
    }
}
