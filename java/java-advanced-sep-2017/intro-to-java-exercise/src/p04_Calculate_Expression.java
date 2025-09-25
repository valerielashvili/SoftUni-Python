import java.util.Scanner;

public class p04_Calculate_Expression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double f1 = (Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2));
        double f1Pow = (a + b + c) / Math.sqrt(c);
        f1 = Math.pow(f1, f1Pow);

        double f2 = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3));
        double f2Pow = a - b;
        f2 = Math.pow(f2, f2Pow);

        double difference = Math.abs((a + b + c) / 3 - (f1 + f2) / 2);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, difference);
    }
}
