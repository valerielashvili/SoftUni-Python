package p07_Car_Salesman;

class Car {
    private static final int DEFAULT_WEIGHT = 0;
    private static final String DEFAULT_COLOR = "n/a";

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = DEFAULT_WEIGHT;
        this.color = DEFAULT_COLOR;
    }

    Car(String model, Engine engine, String color) {
        this(model, engine);
        this.weight = DEFAULT_WEIGHT;
        this.color = color;
    }

    Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
        this.color = DEFAULT_COLOR;
    }

    Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.weight == 0 && this.engine.getDisplacement() == 0) {
            return String.format("%s:\n  %s:\n    Power: %d\n    Displacement: n/a\n    Efficiency: %s\n  Weight: n/a\n" +
                            "  Color: %s", this.model, this.engine.getModel(), this.engine.getPower(),
                    this.engine.getEfficiency(), this.color);

        } else if (this.weight == 0) {
            return String.format("%s:\n  %s:\n    Power: %d\n    Displacement: %d\n    Efficiency: %s\n  Weight: n/a\n" +
                            "  Color: %s", this.model, this.engine.getModel(), this.engine.getPower(),
                    this.engine.getDisplacement(), this.engine.getEfficiency(), this.color);

        } else if (this.engine.getDisplacement() == 0) {
            return String.format("%s:\n  %s:\n    Power: %d\n    Displacement: n/a\n    Efficiency: %s\n  Weight: %d\n" +
                            "  Color: %s", this.model, this.engine.getModel(), this.engine.getPower(),
                     this.engine.getEfficiency(), this.weight, this.color);

        } else {
            return String.format("%s:\n  %s:\n    Power: %d\n    Displacement: %d\n    Efficiency: %s\n  Weight: %d\n" +
                            "  Color: %s", this.model, this.engine.getModel(), this.engine.getPower(),
                    this.engine.getDisplacement(), this.engine.getEfficiency(), this.weight, this.color);
        }
    }
}
