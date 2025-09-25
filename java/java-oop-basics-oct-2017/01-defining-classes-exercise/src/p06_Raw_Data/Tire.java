package p06_Raw_Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Tire {
    private List<Double> tirePressure = new ArrayList<>();
    private List<Integer> tireAge = new ArrayList<>();

    Tire(List<Double> tirePressure, List<Integer> tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    List<Double> getTirePressure() {
        return Collections.unmodifiableList(this.tirePressure);
    }
}
