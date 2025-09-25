/* Изчисляване на факториел.
   За естествено число n да се изчисли n! = 1 * 2 * 3 * … * n */

import java.util.Scanner;

public class p09_SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        do {                        // n % 10 връща последната цифра на числото n (остатък)
            sum = sum + (n % 10);   // n / 10 изтрива последната цифра на въведеното n
            n = n / 10;             // По този начин отсичаме по една цифра от числото и последователно ги сумираме
        } while (n > 0);
        System.out.println(sum);
    }
}
