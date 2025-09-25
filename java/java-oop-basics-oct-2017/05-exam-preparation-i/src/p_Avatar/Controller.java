package p_Avatar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Controller {
    private static Nation airNation = new Nation(new ArrayList<>(), new ArrayList<>());
    private static Nation fireNation = new Nation(new ArrayList<>(), new ArrayList<>());
    private static Nation waterNation = new Nation(new ArrayList<>(), new ArrayList<>());
    private static Nation earthNation = new Nation(new ArrayList<>(), new ArrayList<>());

    static Nation getAirNation() {
        return airNation;
    }

    static Nation getFireNation() {
        return fireNation;
    }

    static Nation getWaterNation() {
        return waterNation;
    }

    static Nation getEarthNation() {
        return earthNation;
    }

    static void beginWar() {
        List<Nation> fourNations = new ArrayList<>();
        fourNations.add(airNation);
        fourNations.add(fireNation);
        fourNations.add(waterNation);
        fourNations.add(earthNation);

        double maxNationPower = fourNations.stream().mapToDouble(Nation::calculateNationPower).max().orElse(0);

        fourNations.forEach(n -> {
            if (n.calculateNationPower() < maxNationPower) {
                n.clearNationsSourceOfPower();
            }
        });
    }

    static String getStatus(String type) {
        Nation currentNation = getNation(type);
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(" Nation").append("\n");

        if (currentNation.getBenders().size() > 0) {
            sb.append("Benders:").append("\n");
            sb.append(currentNation.getBenders().stream().map(Object::toString).collect(Collectors.joining("\n")));
            sb.append("\n");
        } else {
            sb.append("Benders: None").append("\n");
        }

        if (currentNation.getMonuments().size() > 0) {
            sb.append("Monuments:").append("\n");
            sb.append(currentNation.getMonuments().stream().map(Object::toString).collect(Collectors.joining("\n")));
            sb.append("\n");
        } else {
            sb.append("Monuments: None").append("\n");
        }
        return sb.toString();
    }

    private static Nation getNation(String type) {
        if ("Air".equals(type)) {
            return airNation;
        } else if ("Fire".equals(type)) {
            return fireNation;
        } else if ("Water".equals(type)) {
            return waterNation;
        } else if ("Earth".equals(type)) {
            return earthNation;
        }
        return null;
    }
}
