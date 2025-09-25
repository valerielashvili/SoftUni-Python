package p_Avatar;

import p_Avatar.benders.Bender;
import p_Avatar.monuments.Monument;

import java.util.Collections;
import java.util.List;

class Nation {
    private List<Bender> benders;
    private List<Monument> monuments;

    Nation(List<Bender> benders, List<Monument> monuments) {
        this.benders = benders;
        this.monuments = monuments;
    }

    void addBender(Bender bender) {
        this.benders.add(bender);
    }

    void addMonument(Monument monument) {
        this.monuments.add(monument);
    }

    List<Bender> getBenders() {
        return Collections.unmodifiableList(this.benders);
    }

    List<Monument> getMonuments() {
        return Collections.unmodifiableList(this.monuments);
    }

    double calculateNationPower() {
        double totalPower = this.benders.stream().mapToDouble(Bender::getTotalPower).sum();
        long monumentsTotalAffinity = this.monuments.stream().mapToLong(Monument::getAffinity).sum();
        return totalPower += (totalPower / 100) * monumentsTotalAffinity;
    }

    void clearNationsSourceOfPower() {
        this.benders.clear();
        this.monuments.clear();
    }
}
