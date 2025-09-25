import java.util.Scanner;

public class p02_Choose_a_Drink_ver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String profession = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        double waterPrice = 0.70;
        double coffeePrice = 1.00;
        double beerPrice = 1.70;
        double teaPrice = 1.20;
        double totalPrice = 0;

        if ("athlete".equals(profession.toLowerCase().trim().replace(" ", ""))) {
            totalPrice = quantity * waterPrice;
            System.out.printf("The %s has to pay %.2f.", profession, totalPrice);
        }
        else if ("businessman".equals(profession.toLowerCase().trim().replace(" ", ""))
                || "businesswoman".equals(profession.toLowerCase().trim().replace(" ", ""))) {
            totalPrice = quantity * coffeePrice;
            System.out.printf("The %s has to pay %.2f.", profession, totalPrice);
        }
        else if ("softunistudent".equals(profession.toLowerCase().trim().replace(" ", ""))) {
            totalPrice = quantity * beerPrice;
            System.out.printf("The %s has to pay %.2f.", profession, totalPrice);
        }
        else {
            totalPrice = quantity * teaPrice;
            System.out.printf("The %s has to pay %.2f.", profession, totalPrice);
        }
    }
}
