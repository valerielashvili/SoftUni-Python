import java.util.Scanner;

public class p03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        if (budget <= 1000) {
            // Camp
            if ("Summer".equals(season)) {
                budget *= 0.65;
                System.out.printf("Alaska - Camp - %.2f", budget);
            } else if ("Winter".equals(season)) {
                budget *= 0.45;
                System.out.printf("Morocco - Camp - %.2f", budget);
            }
        } else if (budget > 1000 && budget <= 3000) {
            // Hut
            if ("Summer".equals(season)) {
                budget *= 0.8;
                System.out.printf("Alaska - Hut - %.2f", budget);
            } else if ("Winter".equals(season)) {
                budget *= 0.6;
                System.out.printf("Morocco - Hut - %.2f", budget);
            }
        } else {
            // Hotel
            if ("Summer".equals(season)) {
                budget *= 0.9;
                System.out.printf("Alaska - Hotel - %.2f", budget);
            } else if ("Winter".equals(season)) {
                budget *= 0.9;
                System.out.printf("Morocco - Hotel - %.2f", budget);
            }
        }
    }
}
