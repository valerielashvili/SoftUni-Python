/* The program prints all possible combinations with 3 letters in the determined interval,
 * skipping combinations containing defined letter inputted from the console (third input).
 * In the end the program should print the number of possible combinations.
 * Allowable interval is from 'a' to 'z'. */

import java.util.Scanner;

public class p06_WordsCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char lStart = scanner.next().charAt(0);     // letter for the beginning of the interval
        char lEnd = scanner.next().charAt(0);       // letter for the end of the interval
        char lSkipped = scanner.next().charAt(0);   // combinations containing third letter should be skipped

        int counter = 0;

        for (char i = lStart; i <= lEnd; i++) {
            if (i == lSkipped) {
                continue;
            }
            for (char j = lStart; j <= lEnd; j++) {
                if (j == lSkipped) {
                    continue;
                }
                for (char k = lStart; k <= lEnd; k++) {
                    if (k == lSkipped) {
                        continue;
                    }
                    counter++;
                    System.out.printf("%c%c%c ", i, j, k);
                }
            }
        }
        System.out.print(counter);
    }
}
