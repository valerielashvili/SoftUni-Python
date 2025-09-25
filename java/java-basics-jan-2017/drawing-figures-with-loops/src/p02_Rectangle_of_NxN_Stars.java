import java.util.Scanner;

public class p02_Rectangle_of_NxN_Stars {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt(scanner.next());
        for (int i = 0; i < n; i++) {
            String text = repeatStr("*", n);
            System.out.println(text);
        }
    }

    public static String repeatStr (String stringToRepeat, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text = text + stringToRepeat;
        }
        return text;
    }
}
