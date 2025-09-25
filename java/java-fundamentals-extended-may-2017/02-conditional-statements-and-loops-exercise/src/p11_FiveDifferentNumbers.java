import java.util.Scanner;

public class p11_FiveDifferentNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        if (b - a < 4)
        {
            System.out.println("No");
        }

        for (int digit1 = a; digit1 <= b; digit1++)
        {
            for (int digit2 = a; digit2 <= b; digit2++)
            {
                for (int digit3 = a; digit3 <= b; digit3++)
                {
                    for (int digit4 = a; digit4 <= b; digit4++)
                    {
                        for (int digit5 = a; digit5 <= b; digit5++)
                        {
                            if (digit1 < digit2 && digit2 < digit3
                                    && digit3 < digit4 && digit4 < digit5)
                            {
                                System.out.printf("%d %d %d %d %d\n", digit1, digit2, digit3, digit4, digit5);
                            }
                        }
                    }
                }
            }
        }
    }
}
