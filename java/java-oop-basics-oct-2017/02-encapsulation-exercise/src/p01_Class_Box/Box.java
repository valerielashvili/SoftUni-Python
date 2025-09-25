package p01_Class_Box;

class Box {
    private double length;
    private double width;
    private double height;

    Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    double getSurfaceArera() {
        return (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    double getLateralArea() {
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    double getVolume() {
        return this.length * this.width * this.height;
    }
}
