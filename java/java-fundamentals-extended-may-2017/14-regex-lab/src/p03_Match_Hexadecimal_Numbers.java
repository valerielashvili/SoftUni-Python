import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_Match_Hexadecimal_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b(0x)?[0-9A-F]+\\b");
        Matcher matcher = pattern.matcher(inputLine);

        String result = "";

        while (matcher.find()) {
            String matchedHexNums = matcher.group();
            result += matchedHexNums + " ";
        }
        System.out.printf("%s", result.trim());
    }
}
