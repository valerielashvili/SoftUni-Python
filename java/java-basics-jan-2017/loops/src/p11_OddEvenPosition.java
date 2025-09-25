import java.text.DecimalFormat;
import java.util.Scanner;

public class p11_OddEvenPosition {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = Double.parseDouble(scanner.nextLine());
        double oddSum = 0;
        double oddMax = -1000000000.0;
        double oddMin = 1000000000.0;
        double evenSum = 0;
        double evenMax = -1000000000.0;
        double evenMin = 1000000000.0;
        String pattern = "###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        for (int i = 1; i <= n; i++) {
            double num = Double.parseDouble(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum += num;
                if (num > evenMax) {
                    evenMax = num;
                } if (num < evenMin) {
                    evenMin = num;
                }
            } else if (i % 2 != 0) {
                oddSum += num;
                if (num > oddMax) {
                    oddMax = num;
                } if (num < oddMin) {
                    oddMin = num;
                }
            }
        }
        if (oddMin == 1000000000.0 && oddMax == -1000000000.0 &&
                evenMin == 1000000000.0 && evenMax == -1000000000.0) {
            System.out.printf("OddSum=%s%nOddMin=No%nOddMax=No%n", decimalFormat.format(oddSum));
            System.out.printf("EvenSum=%s%nEvenMin=No%nEvenMax=No", decimalFormat.format(evenSum));
        } else if (oddMin == 1000000000.0 && oddMax == -1000000000.0) {
            System.out.printf("OddSum=%s%nOddMin=No%nOddMax=No%n", decimalFormat.format(oddSum));
            System.out.printf("EvenSum=%s%nEvenMin=%s%nEvenMax=%s%n", decimalFormat.format(evenSum),
                    decimalFormat.format(evenMin), decimalFormat.format(evenMax));
        } else if (evenMin == 1000000000.0 && evenMax == -1000000000.0) {
            System.out.printf("OddSum=%s%nOddMin=%s%nOddMax=%s%n", decimalFormat.format(oddSum),
                    decimalFormat.format(oddMin), decimalFormat.format(oddMax));
            System.out.printf("EvenSum=%s%nEvenMin=No%nEvenMax=No", decimalFormat.format(evenSum));
        } else {
            System.out.printf("OddSum=%s%nOddMin=%s%nOddMax=%s%n", decimalFormat.format(oddSum),
                    decimalFormat.format(oddMin), decimalFormat.format(oddMax));
            System.out.printf("EvenSum=%s%nEvenMin=%s%nEvenMax=%s%n", decimalFormat.format(evenSum),
                    decimalFormat.format(evenMin), decimalFormat.format(evenMax));
        }
    }
}
