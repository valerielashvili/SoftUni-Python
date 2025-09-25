import java.util.Scanner;

public class p12_TestNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int sumBoundary = Integer.parseInt(scanner.nextLine());

        int totalSum = 0;
        int counter = 0;

        for (int digit1 = n; digit1 >= 1; digit1--)
        {
            for (int digit2 = 1; digit2 <= m; digit2++)
            {
                totalSum += 3 * digit1 * digit2;
                counter++;

                if (totalSum >= sumBoundary)
                {
                    System.out.printf("%d combinations\nSum: %d >= %d\n", counter, totalSum, sumBoundary);
                    return;
                }
            }
        }
        System.out.printf("%d combinations\nSum: %d", counter, totalSum);
    }
}
