package p01_Vehicles;

class Truck extends Vehicle {
    Truck(double fuelQuantity, double fuelConsumptionInLitersPerKm) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm);
    }

    @Override
    void setFuelQuantity(double fuelQuantity) {
        double truckFuelQuantity = fuelQuantity * 0.95;
        super.setFuelQuantity(truckFuelQuantity);
    }

    @Override
    void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        super.setFuelConsumptionInLitersPerKm(fuelConsumptionInLitersPerKm + 1.6);
    }

    @Override
    void refuel(double litres) {
        double truckFuel = litres * 0.95;
        super.refuel(truckFuel);
    }
}
