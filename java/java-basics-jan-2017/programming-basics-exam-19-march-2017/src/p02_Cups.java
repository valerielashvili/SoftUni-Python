import java.util.Scanner;

public class p02_Cups {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cupsAmountPlan = Double.parseDouble(scanner.nextLine());
        double numberEmployees = Double.parseDouble(scanner.nextLine());
        double days = Double.parseDouble(scanner.nextLine());

        double workingTime = numberEmployees * days * 8;
        double resultCups = Math.floor(workingTime / 5);

        if (resultCups > cupsAmountPlan) {
            double profit = (resultCups - cupsAmountPlan) * 4.2;
            System.out.printf("%.2f extra money", profit);
        } else {
            double losses = (cupsAmountPlan - resultCups) * 4.2;
            System.out.printf("Losses: %.2f", losses);
        }
    }
}