package p1_Need_for_Speed.entities.races;

import p1_Need_for_Speed.entities.cars.Car;

import java.util.*;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    protected Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.participants.add(car);
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    protected int getLength() {
        return this.length;
    }

    protected String getRoute() {
        return this.route;
    }

    protected int getPrizePool() {
        return this.prizePool;
    }

    protected abstract int calculatePoints(Car car);

    private Map<Integer, Car> getWinners() {
        Map<Integer, Car> winners = new HashMap<>();
        final int[] position = {1};
        this.participants.stream()
                .sorted((c1, c2) -> Integer.compare(this.calculatePoints(c2), this.calculatePoints(c1)))
                .limit(3)
                .forEach(c -> winners.putIfAbsent(position[0]++, c));

        return winners;
    }

    private int getPrize(int position) {
        if (position == 1) {
            return (this.prizePool * 50) / 100;
        } else if (position == 2) {
            return  (this.prizePool * 30) / 100;
        } else if (position == 3) {
            return  (this.prizePool * 20) / 100;
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s", this.route, this.length)).append(System.lineSeparator());
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
