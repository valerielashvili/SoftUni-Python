import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p05_Match_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        Pattern pattern = Pattern.compile("(^|(?<=\\s))-?\\d+(\\.\\d+)?($|(?=\\s))");
        Matcher matcher = pattern.matcher(inputLine);

        while (matcher.find()) {
            String number = matcher.group();
            System.out.printf("%s ", number);
        }
    }
}
