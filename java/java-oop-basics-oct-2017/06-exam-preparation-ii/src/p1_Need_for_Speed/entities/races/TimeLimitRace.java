package p1_Need_for_Speed.entities.races;

import p1_Need_for_Speed.entities.cars.Car;

public class TimeLimitRace extends Race {
    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    @Override
    protected int calculatePoints(Car car) {
        return super.getLength() * ((car.getHorsepower() / 100) * car.getAcceleration());
    }

    @Override
    public String toString() {
        Car car = super.getParticipants().get(0);
        int points = this.calculatePoints(car);
        String earnedTime = "";
        int prize = 0;
        if (points <= this.goldTime) {
            earnedTime = "Gold";
            prize = super.getPrizePool();
        } else if (points <= this.goldTime + 15) {
            earnedTime = "Silver";
            prize = (super.getPrizePool() * 50) / 100;
        } else if (points > this.goldTime + 15) {
            earnedTime = "Bronze";
            prize = (super.getPrizePool() * 30) / 100;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s", super.getRoute(), super.getLength()))
                .append(System.lineSeparator())
                .append(String.format("%s %s - %d s.", car.getBrand(), car.getModel(), points))
                .append(System.lineSeparator())
                .append(String.format("%s Time, $%d.", earnedTime, prize));
        return sb.toString();
    }
}
