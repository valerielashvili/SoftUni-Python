import java.util.Scanner;

public class p01_Rectangle_Area {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        double result = a * b;

        System.out.printf("%.2f", result);
    }
}
