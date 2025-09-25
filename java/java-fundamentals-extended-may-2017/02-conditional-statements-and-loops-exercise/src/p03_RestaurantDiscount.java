import java.util.Scanner;

public class p03_RestaurantDiscount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantity = Integer.parseInt(scanner.nextLine());
        String pack = scanner.nextLine().toLowerCase();

        String hall = "";
        int price = 0;
        double discount = 0;

        if (quantity <= 50) { // Small Hall - for groups less then 50

            hall = "Small Hall";
            price += 2500;
        }
        else if (quantity > 50 && quantity <= 100) { // Terrace - for groups more then 50, but less then 100
            hall = "Terrace";
            price += 5000;
        }
        else if (quantity > 100 && quantity <= 120) { // Great Hall - for groups more then 100, but less then 120
            hall = "Great Hall";
            price += 7500;
        }
        if ("normal".equals(pack)) {
            price += 500;
            discount = 0.05;
        }
        else if ("gold".equals(pack)) {
            price += 750;
            discount = 0.1;
        }
        else if ("platinum".equals(pack)) {
            price += 1000;
            discount = 0.15;
        }
        if (quantity > 120) {
            System.out.println("We do not have an appropriate hall.");
        }
        else {
            System.out.printf("We can offer you the %s\nThe price per person is %.2f$", hall, (price - (price * discount)) / quantity);
        }
    }
}
