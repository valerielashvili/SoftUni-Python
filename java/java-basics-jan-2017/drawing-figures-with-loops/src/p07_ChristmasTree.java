import java.util.Scanner;

public class p07_ChristmasTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n + 1; i++) {
            String stars = repeatStr("*", i);
            String spaces = repeatStr(" ", n - i);
            System.out.println(spaces + stars + " | " + stars + spaces);
        }
    }
    public static String repeatStr (String strToRepeat, int count) {
        String line = "";
        for (int i = 0; i < count; i++) {
            line = line + strToRepeat;
        }
        return line;
    }
}
