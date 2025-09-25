import java.util.Scanner;

public class p13_AreaOfFigures {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputNum = scanner.nextLine();
                                            // Въвеждаме размерите на геометрична фигура и пресмятаме лицето й
        if (inputNum.equals("square")) {    // Проверяваме входните данни на съответствие с една от геометричните фигури
            Double area = Double.parseDouble(scanner.nextLine());
            area = area * area;
            System.out.printf("%.3f", area);

        } else if (inputNum.equals("rectangle")) {
            Double side1 = Double.parseDouble(scanner.nextLine());
            Double side2 = Double.parseDouble(scanner.nextLine());
            Double area = side1 * side2;
            System.out.printf("%.3f", area);

        } else if (inputNum.equals("circle")) {
            Double r = Double.parseDouble(scanner.nextLine());
            Double area = Math.PI * r * r;
            System.out.printf("%.3f", area);

        } else if (inputNum.equals("triangle")) {
            Double a = Double.parseDouble(scanner.nextLine());
            Double h = Double.parseDouble(scanner.nextLine());
            Double area = a * h / 2;
            System.out.printf("%.3f", area);
        }
    }
}
