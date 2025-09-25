package p1_Need_for_Speed.core;

import p1_Need_for_Speed.entities.cars.Car;
import p1_Need_for_Speed.entities.garage.Garage;
import p1_Need_for_Speed.entities.races.Race;
import p1_Need_for_Speed.factories.CarFactory;
import p1_Need_for_Speed.factories.RaceFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static p1_Need_for_Speed.utilities.Constants.*;

public class CarManager {
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new HashMap<>();
        this.races = new HashMap<>();
        this.garage = new Garage(new ArrayList<>());
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower,
                         int acceleration, int suspension, int durability) {
        Car car = null;
        if (PERFORMANCE_CAR_TYPE.equals(type)) {
            car = CarFactory.createPerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        } else if (SHOW_CAR_TYPE.equals(type)) {
            car = CarFactory.createShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        }
        this.cars.putIfAbsent(id, car);

    }
    public String check(int carId) {
        if (this.cars.containsKey(carId)) {
            return this.cars.get(carId).toString();
        }
        return null;
    }
    public void open(int id, String type, int length, String route, int prizePool, int... additionalParam) {
        Race race = null;
        if (CASUAL_RACE_TYPE.equals(type)) {
            race = RaceFactory.createCasualRace(length, route, prizePool);
        } else if (DRAG_RACE_TYPE.equals(type)) {
            race = RaceFactory.createDragRace(length, route, prizePool);
        } else if (DRIFT_RACE_TYPE.equals(type)) {
            race = RaceFactory.createDriftRace(length, route, prizePool);
        } else if (TIMELIMIT_RACE_TYPE.equals(type)) {
            race = RaceFactory.createTimeLimitRace(length, route, prizePool, additionalParam[0]);
        } else if (CIRCUIT_RACE_TYPE.equals(type)) {
            race = RaceFactory.createCircuitRace(length, route, prizePool, additionalParam[0]);
        }
        this.races.putIfAbsent(id, race);
    }
    public void participate(int carId, int raceId) {
        if (this.cars.containsKey(carId) && this.races.containsKey(raceId) &&
                !this.garage.getParkedCars().contains(this.cars.get(carId))) {
            Car car = this.cars.get(carId);
            Race race = this.races.get(raceId);
            if (race.getClass().getSimpleName().equals(TIMELIMIT_RACE_TYPE + "Race") && race.getParticipants().size() == 1) {
                return;
            }
            race.addCar(car);
        }
    }
    public String start(int raceId) {
        if (this.races.containsKey(raceId) && this.races.get(raceId).getParticipants().size() != 0) {
            return this.races.remove(raceId).toString();
        }
        return "Cannot start the race with zero participants.";
    }
    public void park(int carId) {
        if (this.cars.containsKey(carId)) {
            Car car = this.cars.get(carId);
            long countOfRaces = this.races.values().stream().filter(r -> r.getParticipants().contains(car)).count();
            if (countOfRaces == 0) {
                this.garage.park(car);
            }
        }
    }
    public void unpark(int carId) {
        if (this.cars.containsKey(carId) && this.garage.getParkedCars().contains(this.cars.get(carId))) {
            Car car = this.cars.get(carId);
            this.garage.unPark(car);
        }
    }
    public void tune(int tuneIndex, String addOn) {
        if (garage.getParkedCars().size() != 0) {
            this.garage.tune(tuneIndex, addOn);
        }
    }

}
