package p02_Class_Box_Data_Validation;

class Box {
    private double length;
    private double width;
    private double height;

    Box(double length, double width, double height) throws IllegalArgumentException {
        this.setSides(length, width, height);

    }

    private void setSides(double length, double width, double height) throws IllegalArgumentException {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        } else if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        } else if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.length = length;
        this.width = width;
        this.height = height;
    }

    double getSurfaceArea() {
        return (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    double getLateralArea() {
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    double getVolume() {
        return this.length * this.width * this.height;
    }
}
