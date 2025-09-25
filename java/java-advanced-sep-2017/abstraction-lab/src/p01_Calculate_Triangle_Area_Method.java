import java.util.Scanner;

public class p01_Calculate_Triangle_Area_Method {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        double area = triangleArea(base, height);
        System.out.printf("Area = %.2f", area);
    }

    private static double triangleArea(double base, double height) {
        double result = base * height / 2;
        return result;
    }
}
