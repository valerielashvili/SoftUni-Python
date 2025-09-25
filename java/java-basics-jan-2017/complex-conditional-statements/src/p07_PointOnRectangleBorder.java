import java.util.Scanner;

public class p07_PointOnRectangleBorder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

        boolean onLeftSide = (x == x1) && (y >= y1) && (y <= y2);
        boolean onRightSide = (x == x2) && (y >= y1) && (y <= y2);
        boolean onUpSide = (y == y1) && (x >= x1) && (x <= x2);
        boolean onDownSide = (y == y2) && (x >= x1) && (x <= x2);
        boolean inside = (x > x1 && x < x2) && (y > y1 && y < y2);

        if (onLeftSide || onRightSide || onUpSide || onDownSide) {
            System.out.println("Border");
        } else if (inside) {
            System.out.println("Inside");
        } else {
            System.out.println("Outside");
        }
    }
}
