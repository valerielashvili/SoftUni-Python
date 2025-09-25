import java.util.Arrays;
import java.util.Scanner;

public class p06_Batteries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] capacities = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        double[] usagePerHour = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();
        int hoursToTest = Integer.parseInt(scanner.nextLine());

        double[] batteryStatus = new double[capacities.length];

        for (int i = 0; i < capacities.length; i++) {
            double drainedEnergy = usagePerHour[i] * hoursToTest;
            batteryStatus[i] = drainedEnergy;
        }

        for (int i = 0; i < batteryStatus.length; i++) {
            if (batteryStatus[i] < capacities[i]) {
                double remainedEnergy = capacities[i] - batteryStatus[i];
                double percentage = (remainedEnergy / capacities[i]) * 100;
                System.out.printf("Battery %d: %.2f mAh (%.2f)%%\n", i + 1, remainedEnergy, percentage);
            } else {
                int lasted = (int)Math.ceil(capacities[i] / usagePerHour[i]);
                System.out.printf("Battery %d: dead (lasted %d hours)\n", i + 1, lasted);
            }
        }
    }
}
