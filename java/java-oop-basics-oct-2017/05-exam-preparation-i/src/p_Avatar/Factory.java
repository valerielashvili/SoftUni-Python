package p_Avatar;

import p_Avatar.benders.*;
import p_Avatar.monuments.*;

final class Factory {
    static void createBender(String type, String name, int power, double additionalProp) {
        if ("Air".equals(type)) {
            Controller.getAirNation().addBender(new AirBender(name, power, additionalProp));
        } else if ("Water".equals(type)) {
            Controller.getWaterNation().addBender(new WaterBender(name, power, additionalProp));
        } else if ("Fire".equals(type)) {
            Controller.getFireNation().addBender(new FireBender(name, power, additionalProp));
        } else if ("Earth".equals(type)) {
            Controller.getEarthNation().addBender(new EarthBender(name, power, additionalProp));
        }
    }

    static void createMonument(String type, String name, int affinity) {
        if ("Air".equals(type)) {
            Controller.getAirNation().addMonument(new AirMonument(name, affinity));
        } else if ("Water".equals(type)) {
            Controller.getWaterNation().addMonument(new WaterMonument(name, affinity));
        } else if ("Fire".equals(type)) {
            Controller.getFireNation().addMonument(new FireMonument(name, affinity));
        } else if ("Earth".equals(type)) {
            Controller.getEarthNation().addMonument(new EarthMonument(name, affinity));
        }
    }
}
