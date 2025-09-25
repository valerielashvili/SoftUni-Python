import java.util.Scanner;

public class p02_ChangeTiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine()); // Четем 7 реда входни данни
        double floorWidth = Double.parseDouble(scanner.nextLine());
        double floorLength = Double.parseDouble(scanner.nextLine());
        double triangleSide = Double.parseDouble(scanner.nextLine());
        double triangleHeight = Double.parseDouble(scanner.nextLine());
        double pricePerTile = Double.parseDouble(scanner.nextLine());
        double handyManFee = Double.parseDouble(scanner.nextLine());

        double floorArea = floorWidth * floorLength;
        double triangleArea = triangleSide * triangleHeight / 2d;
        double neededTiles = Math.ceil(floorArea / triangleArea) + 5d;
        double totalPrice = neededTiles * pricePerTile + handyManFee;
        double leftCash = budget - totalPrice;

        if (leftCash >= 0d) {
            System.out.printf("%.2f lv left.%n", leftCash);
        } else {
            System.out.println();
            System.out.printf("You'll need %.2f lv more.%n", -leftCash);
        }
    }
}
