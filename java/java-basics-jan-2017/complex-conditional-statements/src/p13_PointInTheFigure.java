import java.util.Scanner;

public class p13_PointInTheFigure {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = Integer.parseInt(scanner.nextLine());
        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());

        int x0 = 0; int y0 = 0;
        int x1 = 3 * h; int y1 = h;
        int x2 = h; int y2 = h;
        int x3 = 2 * h; int y3 = 4 * h;

        boolean insideRec1 = x > x0 && x < x1 && y > y0 && y < y1;
        boolean onBorderRec1 = (x >= x0 && x <= x1 && y == y0) || (y >= y0 && y <= y1 && x == x1) ||
                               (x >= x0 && x <= x2 && y == y2) || (x >= x3 && x <= x1 && y == y1) ||
                               (y >= y0 && y <= y1 && x == x0);
        boolean insideRec2 = (x > x2 && x < x3 && y > y2 && y < y3) || (x > x2 && x < x3 && y == y2);
        boolean onBorderRec2 = (y >= y2 && y <= y3 && x == x3) || (x >= x2 && x <= x3 && y == y3) ||
                               (y >= y2 && y <= y3 && x == x2);

        if (insideRec1) {
            System.out.println("inside");
        } else if (onBorderRec1) {
            System.out.println("border");
        } else if (insideRec2) {
            System.out.println("inside");
        } else if (onBorderRec2) {
            System.out.println("border");
        } else {
            System.out.println("outside");
        }
    }
}
