package p06_Raw_Data;

import java.util.List;

class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tires;

    Car (String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
         List<Double> tirePressure, List<Integer> tireAge) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires = new Tire(tirePressure, tireAge);
    }

    String getModel() {
        return model;
    }

    int getEnginePower() {
        return this.engine.getEnginePower();
    }

    String getCargoType() {
        return this.cargo.getCargoType();
    }

    List<Double> getTirePressure() {
        return tires.getTirePressure();
    }
}
