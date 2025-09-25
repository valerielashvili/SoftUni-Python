import java.text.DecimalFormat;
import java.util.Scanner;

public class p22_Debugging_Exercise_Mining_Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String decrypted = "";
        double totalValue = 0.0D;

        for(int i = 1; i <= n; ++i) {
            int number = Integer.parseInt(scanner.nextLine());
            int digitOne = number / 100;
            int digitTwo = number / 10 % 10;
            int digitThree = number % 10;
            totalValue += (double)(digitOne + digitTwo + digitThree) / (double)n;

            int charCode = 0;
            if (i % 2 != 0) {
                charCode = digitOne * 10 + digitThree - digitTwo;
            } else {
                charCode = digitOne * 10 + digitThree + digitTwo;
            }

            if (charCode >= 65 && charCode <= 90 || charCode >= 97 && charCode <= 122) {
                decrypted = decrypted + (char)charCode;
            }
        }

        String pattern = "##.#######";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String formattedTotalValue = decimalFormat.format(totalValue);
        System.out.printf("Message: %s\n", decrypted);
        System.out.printf("Value: %s\n", formattedTotalValue);
    }
}
