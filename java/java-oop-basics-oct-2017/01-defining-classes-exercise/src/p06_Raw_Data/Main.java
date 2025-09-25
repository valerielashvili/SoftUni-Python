package p06_Raw_Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            List<Double> tirePressure = new ArrayList<>();
            List<Integer> tireAge = new ArrayList<>();

            for (int j = 5; j < tokens.length - 1; j += 2) {
                tirePressure.add(Double.parseDouble(tokens[j]));
                tireAge.add(Integer.parseInt(tokens[j + 1]));
            }
            Car car = new Car(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[3]), tokens[4], tirePressure, tireAge);
            cars.add(car);
        }
        String command = reader.readLine();

        System.out.println(cars.stream()
                .filter(c -> c.getCargoType().equals(command)
                        && (c.getTirePressure().stream().anyMatch(x -> x < 1)
                        || IntStream.of(c.getEnginePower()).anyMatch(x -> x > 250)))
                .map(Car::getModel)
                .collect(Collectors.joining("\n")));
    }
}
