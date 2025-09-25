public class Ferrari implements Car {
    private final String DEFAULT_CAR_MODEL = "488-Spider";
    private String driversName;

    Ferrari(String driversName) {
        this.setDriversName(driversName);
    }

    private void setDriversName(String driversName) {
        this.driversName = driversName;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushTheGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.DEFAULT_CAR_MODEL, this.useBrakes(), this.pushTheGasPedal(), this.driversName);
    }
}
