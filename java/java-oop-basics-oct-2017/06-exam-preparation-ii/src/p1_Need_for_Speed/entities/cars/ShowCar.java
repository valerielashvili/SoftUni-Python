package p1_Need_for_Speed.entities.cars;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration,
                      int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    @Override
    public void tuneCar(int tuneIndex, String tuneAddOn) {
        super.tuneCar(tuneIndex, tuneAddOn);
        this.stars += tuneIndex;
    }

    @Override
    public String toString() {
        return String.format("%s%d *", super.toString(), this.stars);
    }
}
