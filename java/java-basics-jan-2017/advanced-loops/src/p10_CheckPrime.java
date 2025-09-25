/* Проверяваме дали число е просто */

import java.util.Scanner;

public class p10_CheckPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean prime = true;

        if (n <= 1) {
            prime = false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {   // От просто число никога не се извлича корен квадрат
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        if (prime) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }
}
