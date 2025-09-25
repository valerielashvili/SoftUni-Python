package p07_Car_Salesman;

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
        List<Engine> enginesList = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        String[] tokens;
        while (n-- > 0) {
            tokens = reader.readLine().split("\\s+");
            createEngine(enginesList, tokens);
        }

        n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            tokens = reader.readLine().split("\\s+");
            createCar(cars, enginesList, tokens);
        }

        System.out.println(cars.stream().map(Object::toString).collect(Collectors.joining("\n")));
    }

    private static void createCar(List<Car> cars, List<Engine> enginesList, String[] tokens) {
        Car car = null;
        int index = 0;
        for (int i = 0; i <= enginesList.size() - 1; i++) {
            if (enginesList.get(i).getModel().equals(tokens[1])) {
                index = i;
            }
        }

        if (tokens.length == 2) {
            car = new Car(tokens[0], enginesList.get(index));
        } else if (tokens.length == 3) {
            if (Character.isDigit(tokens[2].charAt(0))) {
                car = new Car(tokens[0], enginesList.get(index), Integer.parseInt(tokens[2]));
            } else {
                car = new Car(tokens[0], enginesList.get(index), tokens[2]);
            }
        } else if (tokens.length == 4) {
            car = new Car(tokens[0], enginesList.get(index), Integer.parseInt(tokens[2]), tokens[3]);
        }
        cars.add(car);
    }

    private static void createEngine(List<Engine> enginesList, String[] tokens) {
        Engine engine = null;
        if (tokens.length == 2) {
            engine = new Engine(tokens[0], Integer.parseInt(tokens[1]));
        } else if (tokens.length == 3) {
            if (Character.isDigit(tokens[2].charAt(0))) {
                engine = new Engine(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            } else {
                engine = new Engine(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }
        } else if (tokens.length == 4) {
            engine = new Engine(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]);
        }
        enginesList.add(engine);
    }
}
