import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p01_Match_Full_Name {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");
        Matcher matcher = pattern.matcher(inputLine);

        while (matcher.find()) {
            String result = matcher.group();
            System.out.printf("%s ", result);
        }
    }
}
