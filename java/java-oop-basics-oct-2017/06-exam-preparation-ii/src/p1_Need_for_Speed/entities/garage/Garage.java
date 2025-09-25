package p1_Need_for_Speed.entities.garage;

import p1_Need_for_Speed.entities.cars.Car;

import java.util.Collections;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public List<Car> getParkedCars() {
        return Collections.unmodifiableList(this.parkedCars);
    }

    public void park(Car car) {
        this.parkedCars.add(car);
    }

    public void unPark(Car car) {
        this.parkedCars.remove(car);
    }

    public void tune(int tuneIndex, String tuneAddOn) {
        this.parkedCars.forEach(c -> c.tuneCar(tuneIndex, tuneAddOn));
    }
}
