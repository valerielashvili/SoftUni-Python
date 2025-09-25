import java.util.Scanner;

public class p09_Triangle_Formations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        if ((a + b <= c || b + c <= a) && (b + c <= a || a + c <= b)) {
            System.out.println("Invalid Triangle.");
        } else if (a * a + b * b == c * c) {
            System.out.println("Triangle is valid.\nTriangle has a right angle between sides a and b");
        } else if (b * b + c * c == a * a) {
            System.out.println("Triangle is valid.\nTriangle has a right angle between sides b and c");
        } else if (c * c + a * a == b * b) {
            System.out.println("Triangle is valid.\nTriangle has a right angle between sides a and c");
        } else if (a == b && a == c) {
            System.out.println("Triangle is valid.\nTriangle has no right angles");
        }

    }
}
