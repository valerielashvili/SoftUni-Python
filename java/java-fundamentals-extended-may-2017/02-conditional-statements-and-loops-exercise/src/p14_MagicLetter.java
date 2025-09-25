import java.util.Scanner;

public class p14_MagicLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstLetter = scanner.next().charAt(0);
        char secondLetter = scanner.next().charAt(0);
        char thirdLetter = scanner.next().charAt(0);

        for (char i = firstLetter; i <= secondLetter; i++)
        {
            for (char j = firstLetter; j <= secondLetter; j++)
            {
                for (char k = firstLetter; k <= secondLetter; k++)
                {
                    if (i == thirdLetter || j == thirdLetter || k == thirdLetter)
                    {
                        continue;
                    }
                    System.out.printf("%s%s%s ", i, j, k);
                }
            }
        }
    }
}
