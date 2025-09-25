package p05_Speed_Racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Car> cars = new ArrayList<>();
        String[] tokens;
        while (n-- > 0) {
            tokens = reader.readLine().split("\\s+");
            Car car = new Car(tokens[0], Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
            cars.add(car);
        }

        String inputLine = reader.readLine();
        while (!"End".equals(inputLine)) {
            tokens = inputLine.split("\\s+");
            final String model = tokens[1];
            final int distance = Integer.parseInt(tokens[2]);

            if ("Drive".equals(tokens[0])) {
                cars.stream()
                        .filter(c -> c.getModel().equals(model))
                        .forEach(car -> car.calculateDistance(distance));
            }
            inputLine = reader.readLine();
        }

        System.out.println(cars.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n")));
    }
}
