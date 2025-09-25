import java.util.Scanner;

public class p01_Distance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double speed = Double.parseDouble(scanner.nextLine());

        double firstTime = Double.parseDouble(scanner.nextLine()) / 60.0d;
        double secondTime = Double.parseDouble(scanner.nextLine()) / 60.0d;
        double thirdTime = Double.parseDouble(scanner.nextLine()) / 60.0;

        double distance1 = speed * firstTime;
        speed = speed * 1.10d; // speed + speed * 0.10d;
        double distance2 = speed * secondTime;
        speed = speed * 0.95d; // speed - speed * 0.05d;
        double distance3 = speed * thirdTime;

        System.out.printf("%.2f", distance1 + distance2 + distance3);
    }
}
