import java.util.Scanner;

public class p09_House {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int starCount = 0;

        if (n % 2 == 0) {
            starCount = 2;
        } else {
            starCount = 1;
        }

        for (int i = 0; i < (n+1)/2; i++) {
            String stars = repeatStr("*", starCount);
            String dashes = repeatStr("-", (n - starCount) / 2);
            starCount += 2;
            System.out.println(dashes + stars + dashes);
        }
        for (int i = 0; i < n / 2; i++) {
            String stars = repeatStr("*", n - 2);
            System.out.println("|" + stars + "|");
        }
    }
    static String repeatStr (String strToRepeat, int count) {
        String line = "";
        for (int i = 0; i < count; i++) {
            line += strToRepeat;
        }
        return line;
    }
}
