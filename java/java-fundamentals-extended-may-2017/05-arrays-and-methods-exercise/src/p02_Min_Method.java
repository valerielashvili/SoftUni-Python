import java.util.Scanner;

public class p02_Min_Method {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int result = getMinVal(num1, getMinVal(num2, num3));

        System.out.println(result);
    }

    private static int getMinVal (int a, int b) {
        int minVal = Integer.MAX_VALUE;
        if (a < minVal) {
            minVal = a;
        } if (b < minVal) {
            minVal = b;
        }
        return minVal;
    }
}
