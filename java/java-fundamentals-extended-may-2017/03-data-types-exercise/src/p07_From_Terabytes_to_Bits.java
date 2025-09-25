import java.util.Scanner;

public class p07_From_Terabytes_to_Bits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.parseDouble(scanner.nextLine());
        double terabyte = 8.796093022208E12D;
        double result = terabyte * num;
        System.out.printf("%.0f", result);
    }
}
