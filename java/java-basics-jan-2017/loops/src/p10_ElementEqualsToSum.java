import java.util.Scanner;

public class p10_ElementEqualsToSum {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            sum += num;
            if (num > max) {
                max = num;
            }
        }
        sum -= max;
        if (sum == max) {
            System.out.printf("Yes sum = %d", sum);
        } else {
            int diff = Math.abs(sum - max);
            System.out.printf("No diff = %d", diff);
        }
    }
}
