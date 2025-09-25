import java.util.Scanner;

public class p12_EqualPairs {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int currSum = 0;
        int prevSum = 0;
        boolean areAllEqual = true;
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num1 = Integer.parseInt(scanner.nextLine());
            int num2 = Integer.parseInt(scanner.nextLine());
            currSum = num1 + num2;
            if (i > 0 && currSum != prevSum) {
                areAllEqual = false;
                int diff = Math.abs(currSum - prevSum);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
            prevSum = currSum;
        }
        if (areAllEqual) {
            System.out.printf("Yes, value=%d%n", currSum);
        } else {
            System.out.printf("No, maxdiff=%d%n", maxDiff);
        }
    }
}
