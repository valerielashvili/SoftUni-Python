package p03_Shapes;

abstract class Shape {
    private double perimeter;
    private double area;

    double getPerimeter() {
        return this.perimeter;
    }

    void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    double getArea() {
        return this.area;
    }

    void setArea(double area) {
        this.area = area;
    }

    abstract void calculatePerimeter();
    abstract void calculateArea();
}
