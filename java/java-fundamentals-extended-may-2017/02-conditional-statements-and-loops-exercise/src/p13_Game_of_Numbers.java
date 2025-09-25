import java.util.Scanner;

public class p13_Game_of_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int magicalNum = Integer.parseInt(scanner.nextLine());

        int digitsSum = 0;
        int counter = 0;
        Boolean magicalNumFound = false;

        int firstNum = 0;
        int secondNum = 0;

        for (int digit1 = n; digit1 <= m; digit1++)
        {
            for (int digit2 = n; digit2 <= m; digit2++)
            {
                counter++;

                if (digit1 + digit2 == magicalNum)
                {
                    digitsSum = digit1 + digit2;
                    firstNum = digit1;
                    secondNum = digit2;
                    magicalNumFound = true;
                    break;
                }
            }
        }
        if (magicalNumFound)
        {
            System.out.printf("Number found! %d + %d = %d", firstNum, secondNum, digitsSum);
        }
        else
        {
            System.out.printf("%d combinations - neither equals %d", counter, magicalNum);
        }
    }
}
