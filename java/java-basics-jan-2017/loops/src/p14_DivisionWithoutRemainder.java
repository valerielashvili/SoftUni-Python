/* The program calculates which numbers are dividing by 2, 3 and 4 without a remainder */

import java.util.Scanner;

public class p14_DivisionWithoutRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        double p1 = 0;
        double p2 = 0;
        double p3 = 0;

        for (int i = 1; i <= n; i++) {
            int nums = Integer.parseInt(scanner.nextLine());

            if (nums % 2 == 0) {
                p1++;
            }
            if (nums % 3 == 0) {
                p2++;
            }
            if (nums % 4 == 0) {
                p3++;
            }
        }
        p1 =  p1 / n * 100;
        p2 =  p2 / n * 100;
        p3 =  p3 / n * 100;
        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%", p1, p2, p3);
    }
}
