import java.util.Scanner;

public class p02_SmallShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine().toLowerCase();
        String town = scanner.nextLine().toLowerCase();
        double quantity = Double.parseDouble(scanner.nextLine());

        if ("sofia".equals(town)) {
            if ("coffee".equals(product)) {
                System.out.println(quantity * 0.50);
            } else if ("water".equals(product)) {
                System.out.println(quantity * 0.80);
            } else if ("beer".equals(product)) {
                System.out.println(quantity * 1.20);
            } else if ("sweets".equals(product)) {
                System.out.println(quantity * 1.45);
            } else if ("peanuts".equals(product)) {
                System.out.println(quantity * 1.60);
            }
        }

        if ("plovdiv".equals(town)) {
            if ("coffee".equals(product)) {
                System.out.println(quantity * 0.40);
            } else if ("water".equals(product)) {
                System.out.println(quantity * 0.70);
            } else if ("beer".equals(product)) {
                System.out.println(quantity * 1.15);
            } else if ("sweets".equals(product)) {
                System.out.println(quantity * 1.30);
            } else if ("peanuts".equals(product)) {
                System.out.println(quantity * 1.50);
            }
        }

        if ("varna".equals(town)) {
            if ("coffee".equals(product)) {
                System.out.println(quantity * 0.45);
            } else if ("water".equals(product)) {
                System.out.println(quantity * 0.70);
            } else if ("beer".equals(product)) {
                System.out.println(quantity * 1.10);
            } else if ("sweets".equals(product)) {
                System.out.println(quantity * 1.35);
            } else if ("peanuts".equals(product)) {
                System.out.println(quantity * 1.55);
            }
        }
    }
}
