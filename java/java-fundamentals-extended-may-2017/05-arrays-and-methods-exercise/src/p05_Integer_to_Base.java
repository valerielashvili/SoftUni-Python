import java.util.Scanner;

public class p05_Integer_to_Base {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = Long.parseLong(scanner.nextLine());
        int base = Integer.parseInt(scanner.nextLine());

        String toBaseResult = integerToBase(number, base);
        System.out.println(toBaseResult);
    }

    static String integerToBase(long num, int toBase) {
        String result = "";
        while (num > 0) {
            int remainder = (int)num % toBase;
            result = remainder + result;
            num /= toBase;
        }
        return result;
    }
}
