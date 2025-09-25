import java.util.Scanner;

public class p09_CelsiusToFahrenheit {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        float t = Float.parseFloat(console.nextLine());
        float celsius = (float)9 / 5 * t + 32;
        System.out.printf("Temperature °C: %.2f", celsius);
    }
}
