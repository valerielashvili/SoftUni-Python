import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p12_Vehicle_park {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> vehiclePark = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        int soldCnt = 0;

        String inputLine = scanner.nextLine();
        while (!"End of customers!".equals(inputLine)) {
            String[] tokens = inputLine.split("\\s+");
            String vehicle = tokens[0].toLowerCase().charAt(0) + "" + tokens[2];

            if (vehiclePark.contains(vehicle)) {
                int index = vehiclePark.indexOf(vehicle);
                vehiclePark.remove(index);
                int price = vehicle.charAt(0) * Integer.parseInt(vehicle.substring(1, vehicle.length()));
                System.out.printf("Yes, sold for %d$\n", price);
                soldCnt++;
            } else {
                System.out.println("No");
            }
            inputLine = scanner.nextLine();
        }

        System.out.printf("Vehicles left: %s\n", vehiclePark.stream().collect(Collectors.joining(", ")));
        System.out.printf("Vehicles sold: %d", soldCnt);
    }
}
