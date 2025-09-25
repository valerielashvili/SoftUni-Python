import java.util.Scanner;

public class p08_Sunglasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String firstRowStars = repeatStr("*", n*2);
        String spaces = repeatStr(" ", n);
        String firstAndLastRow = firstRowStars + spaces + firstRowStars;
        System.out.println(firstAndLastRow);

        for (int r = 0; r < n-2; r++) {
            String slashes = repeatStr("/", n*2-2);
            String verticalSlashes = repeatStr("|", n);
            if (r == (n-1)/2-1) {
                System.out.println("*" + slashes + "*" + verticalSlashes + "*" + slashes + "*");
            } else {
                System.out.println("*" + slashes + "*" + spaces + "*" + slashes + "*");
            }
        }
        System.out.println(firstAndLastRow);
    }
    public static String repeatStr (String strToRepeat, int count) {
        String line = "";
        for (int i = 0; i < count; i++) {
            line = line + strToRepeat;
        }
        return line;
    }
}
