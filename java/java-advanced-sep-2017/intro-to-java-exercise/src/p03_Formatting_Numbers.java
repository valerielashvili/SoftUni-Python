import java.util.Scanner;

public class p03_Formatting_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        String binaryNum = "";

        if (a >= 0 && a <= 500) {
            binaryNum = Integer.toBinaryString(a);
        }
        System.out.printf("|%-10X", a);
        System.out.printf(String.format("|%10s|", binaryNum).replace(" ", "0"));
        System.out.printf("%10.2f|%-10.3f|", b, c);
    }
}
