package p02_Method_Overriding;

class Rectangle {
    private double sideA;
    private double sideB;

    Rectangle(double sideA) {
        this.sideA = sideA;
    }

    Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    double getSideA() {
        return this.sideA;
    }

    double area() {
        return this.sideA * this.sideB;
    }
}
