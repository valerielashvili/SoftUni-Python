package p02_Method_Overriding;

class Square extends Rectangle {

    Square(double sideA) {
        super(sideA);
    }

    @Override
    double area() {
        return super.getSideA() * super.getSideA();
    }
}
