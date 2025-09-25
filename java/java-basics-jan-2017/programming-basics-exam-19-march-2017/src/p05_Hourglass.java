import java.util.Scanner;

public class p05_Hourglass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int size = 2 * n + 1;
        int dotSize = 0;
        int atSize = size;

        for (int i = 1; i <= n ; i++) {
            String stars = repeatStr("*", size);
            String spaces = repeatStr(" ", size - dotSize - 3);
            String dots = repeatStr(".", dotSize);
            String at = repeatStr("@", atSize - dotSize - 2);

            if (i == 1) {
                System.out.println(stars);
            } else if (i == 2) {
                System.out.println(dots + "*" + spaces + "*" + dots);
            } else if (i > 2) {
                System.out.println(dots + "*" + at + "*" + dots);
            }
            dotSize++;
            atSize--;
        }
        String middleDots = repeatStr(".", n);
        System.out.println(middleDots + "*" + middleDots);

        int spaceSize = 0;

        for (int i = 1; i < n - 1  ; i++) {
            int dotSizeBottom = n - 1;
            String stars = repeatStr("*", size);
            String spaces = repeatStr(" ", spaceSize);
            String dots = repeatStr(".", dotSizeBottom - spaceSize);
            String at = repeatStr("@", size - dotSize - 1);
            dotSize--;
            spaceSize++;

            System.out.println(dots + "*" + spaces + "@" + spaces + "*" + dots);

            if (i == n - 2) {
                System.out.println(".*" + at + "*.");
            }
        }
        String bottomDots = repeatStr("*", 2 * n + 1);
        System.out.println(bottomDots);
    }

    public static String repeatStr (String strToRepeat, int count) {
        String line = "";
        for (int i = 0; i < count; i++) {
            line = line + strToRepeat;
        }
        return line;
    }
}
