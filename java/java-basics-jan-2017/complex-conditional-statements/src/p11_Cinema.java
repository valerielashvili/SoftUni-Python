import java.util.Scanner;

public class p11_Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ticket = scanner.nextLine().toLowerCase();
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        double premiere = 12;
        double normal = 7.50;
        double discount = 5;

        if ("premiere".equals(ticket)) {
            double income = (r * c) * premiere;
            System.out.printf("%.2f leva", income);
        } else if ("normal".equals(ticket)) {
            double income = (r * c) * normal;
            System.out.printf("%.2f leva", income);
        } else if ("discount".equals(ticket)) {
            double income = (r * c) * discount;
            System.out.printf("%.2f leva", income);
        }
    }
}
