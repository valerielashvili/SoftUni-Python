package p11_Cat_Lady;

class Siamese extends Cat {
    private double earSize;

    Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.earSize);
    }
}
