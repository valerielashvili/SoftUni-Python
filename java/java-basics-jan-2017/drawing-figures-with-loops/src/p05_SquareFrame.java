import java.util.Scanner;

public class p05_SquareFrame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String innerStr = repeatStr(" -", n-2);
        String firstAndLastLine = "+" + innerStr + " +";
        System.out.println(firstAndLastLine);
        for (int r = 0; r < n - 2; r++) {
            String bodyString = "|" + innerStr + " |";
            System.out.println(bodyString);
        }
        System.out.print(firstAndLastLine);
    }
    public static String repeatStr (String strToRepeat, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text = text + strToRepeat;
        }
        return text;
    }
}
