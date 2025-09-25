import java.util.Scanner;

public class p05_v2RectangleArea {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String inputA = console.nextLine();
        String inputB = console.nextLine();
        try {
            double a = Double.parseDouble(inputA);
            double b = Double.parseDouble(inputB);
            double area = a*b;
            if (area == Math.round(area)) {
                System.out.println(Math.round(area));
            } else {
                System.out.println(area);
            }
        } catch (Exception e) {
            if (inputA.toCharArray().length == 1 || inputB.toCharArray().length == 1) {
                System.out.println("Въвели сте символ!");
            } else {
                System.out.println("Въвели сте текст!");
            }
        }
        }
    }
