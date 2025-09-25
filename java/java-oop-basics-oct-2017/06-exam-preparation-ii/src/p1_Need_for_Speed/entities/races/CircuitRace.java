package p1_Need_for_Speed.entities.races;

import p1_Need_for_Speed.entities.cars.Car;

import java.util.HashMap;
import java.util.Map;

public class CircuitRace extends Race {
    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    private void decreaseDurability() {
        super.getParticipants().forEach(c -> c.decreaseDurability(this.laps, super.getLength()));
    }

    private Map<Integer, Car> getWinners() {
        Map<Integer, Car> winners = new HashMap<>();
        final int[] position = {1};
        super.getParticipants().stream()
                .sorted((c1, c2) -> Integer.compare(this.calculatePoints(c2), this.calculatePoints(c1)))
                .limit(4)
                .forEach(c -> winners.putIfAbsent(position[0]++, c));

        this.decreaseDurability();

        return winners;
    }

    private int getPrize(int position) {
        if (position == 1) {
            return (super.getPrizePool() * 40) / 100;
        } else if (position == 2) {
            return  (super.getPrizePool() * 30) / 100;
        } else if (position == 3) {
            return  (super.getPrizePool() * 20) / 100;
        } else if (position == 4) {
            return  (super.getPrizePool() * 10) / 100;
        }
        return 0;
    }

    @Override
    protected int calculatePoints(Car car) {
        return (car.getHorsepower() / car.getAcceleration()) + (car.getSuspension() + car.getDurability());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d", super.getRoute(), super.getLength() * this.laps)).append(System.lineSeparator());
        this.getWinners().entrySet().forEach(car -> {
            int position = car.getKey();
            int prize = getPrize(position);
            int performancePoints = calculatePoints(car.getValue());

            sb.append(String.format("%d. %s %s %dPP - $%d",
                    position, car.getValue().getBrand(), car.getValue().getModel(), performancePoints, prize))
                    .append(System.lineSeparator());
        });
        return sb.toString().trim();
    }
}
