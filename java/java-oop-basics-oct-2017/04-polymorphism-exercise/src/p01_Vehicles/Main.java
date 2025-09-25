package p01_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Vehicle> vehicles = new HashMap<>();

        String[] carTokens = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));

        String[] truckTokens = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        vehicles.putIfAbsent("Car", car);
        vehicles.putIfAbsent("Truck", truck);

        int countOfVehicle = Integer.parseInt(reader.readLine());

        String pattern = "#.##";
        DecimalFormat df = new DecimalFormat(pattern);
        while (countOfVehicle-- > 0) {
            String[] commandTokens = reader.readLine().split("\\s+");

            switch (commandTokens[0]) {
                case "Drive":
                    try {
                        double distance = Double.parseDouble(commandTokens[2]);
                        vehicles.get(commandTokens[1]).drive(Double.parseDouble(commandTokens[2]));
                        System.out.printf("%s travelled %s km\n", commandTokens[1], df.format(distance));
                    } catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }
                    break;
                case "Refuel":
                    vehicles.get(commandTokens[1]).refuel(Double.parseDouble(commandTokens[2]));
                    break;
            }
        }
        vehicles.values().forEach(System.out::println);
    }
}
