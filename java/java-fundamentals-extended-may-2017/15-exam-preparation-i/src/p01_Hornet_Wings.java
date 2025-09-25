import java.util.Scanner;

public class p01_Hornet_Wings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long wingFlaps = Long.parseLong(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        long endurance = Long.parseLong(scanner.nextLine());

        double metersTraveled = (wingFlaps / 1000) * distance;
        int wingFlapsPerSec = 100;
        long travelTime = (wingFlaps / wingFlapsPerSec) + (wingFlaps / endurance) * 5;

        System.out.printf("%.2f m.%n%d s.", metersTraveled, travelTime);
    }
}
