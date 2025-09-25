import java.util.Scanner;

public class p03_String_Repeater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int repeatVal = scanner.nextInt();

        StringBuilder repeatedString = strRepeater(input, repeatVal);
        System.out.println(repeatedString);
    }

    static StringBuilder strRepeater(String str, int times) {
        StringBuilder appendedStr = new StringBuilder();
        for (int i = 0; i < times; i++) {
            appendedStr.append(str);
        }
        return appendedStr;
    }
}
