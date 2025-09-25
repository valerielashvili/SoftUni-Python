import java.util.Scanner;

public class p03_SquareOfStars {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int r = 0; r < n; r++) {
            System.out.print("*");
            for (int c = 1; c < n; c++) {
                System.out.print(" *");
            }
            System.out.println();
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
