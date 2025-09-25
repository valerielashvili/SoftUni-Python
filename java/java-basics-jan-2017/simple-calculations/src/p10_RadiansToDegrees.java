import java.util.Scanner;

public class p10_RadiansToDegrees {
    public static void main (String[] args) {

        Scanner console = new Scanner(System.in);
        double radians = Double.parseDouble(console.nextLine());
        double degree = radians * 180 / Math.PI;
        System.out.printf("Radians: %.0f", degree);
    }

}
