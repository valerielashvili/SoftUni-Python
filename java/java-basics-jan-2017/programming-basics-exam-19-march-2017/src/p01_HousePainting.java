import java.util.Scanner;

public class p01_HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double greenPaintConsump = 3.4;
        double redPaintConsump = 4.3;

        // Calculating walls square
        double sideWall = x * y;
        double sideWindow = 1.5 * 1.5;
        double sideWallsSquare = 2 * sideWall - 2 * sideWindow;
        double backWall = x * x;
        double enterDooor = 1.2 * 2;
        double backWallsSquare = 2 * backWall - enterDooor;
        double resultWalsSquare = sideWallsSquare + backWallsSquare;
        double greenPaint = resultWalsSquare / greenPaintConsump;

        // Calculating roof square
        double twoRoofRectangle = 2 * (x * y);
        double twoRectangles = 2 * (x * h /2);
        double resultRoofSquare = twoRoofRectangle + twoRectangles;
        double redPaint = resultRoofSquare / redPaintConsump;

        System.out.printf("%.2f%n%.2f", greenPaint, redPaint);
    }
}
