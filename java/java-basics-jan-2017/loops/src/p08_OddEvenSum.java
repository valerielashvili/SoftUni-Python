import java.util.Scanner;

public class p08_OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                oddSum += Integer.parseInt(scanner.nextLine());
            } else {
                evenSum += Integer.parseInt(scanner.nextLine());
            }
        } int diff = Math.abs(oddSum - evenSum);
        if (diff == 0) {
            System.out.printf("Yes%nSum = %d%n", oddSum);
        } else {
            System.out.printf("No%nDiff = %d%n", diff);
        }
    }
}
