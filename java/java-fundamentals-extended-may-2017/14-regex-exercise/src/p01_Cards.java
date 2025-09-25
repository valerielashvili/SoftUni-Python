import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p01_Cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        Pattern pattern = Pattern.compile("(1?[0-9JQKA])([SHDC])");
        Matcher matcher = pattern.matcher(inputLine);
        String result = "";

        while (matcher.find()) {
            boolean powerIsNum = isDigit(matcher.group(1));

            if (powerIsNum) {
                int power = Integer.parseInt(matcher.group(1));
                if (power < 2 || power > 10) {
                    continue;
                }
            }
            String card = matcher.group();
            result += card + ", ";
        }
        result = result.substring(0, result.length() - 2);
        System.out.println(result);
    }

    private static boolean isDigit(String num) {
        boolean isNum = false;
        for (int i = 0; i < num.length(); i++) {
            if (Character.isDigit(num.charAt(i))) {
                isNum = true;
            } else {
                isNum = false;
                break;
            }
        }
        return isNum;
    }
}
