package p07_Car_Salesman;

class Engine {
    private static final int DEFAULT_DISPLACEMENT = 0;
    private static final String DEFAULT_EFFICIENCY = "n/a";

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = DEFAULT_DISPLACEMENT;
        this.efficiency = DEFAULT_EFFICIENCY;
    }

    Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = DEFAULT_EFFICIENCY;
    }

    Engine(String model, int power, String efficiency) {
        this(model, power);
        this.displacement = DEFAULT_DISPLACEMENT;
        this.efficiency = efficiency;
    }

    Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    String getModel() {
        return model;
    }

    int getPower() {
        return power;
    }

    int getDisplacement() {
        return displacement;
    }

    String getEfficiency() {
        return efficiency;
    }
}
