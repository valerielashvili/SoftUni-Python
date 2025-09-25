import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_Rage_Quit {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        Pattern pattern = Pattern.compile("(?<text>\\D+)(?<count>\\d+)");
        Matcher matcher = pattern.matcher(inputLine);

        while (matcher.find()) {
            String text = matcher.group("text");
            int count = Integer.parseInt(matcher.group("count"));
            repeatStr(text, count);
        }
        long countUnique = sb.chars().distinct().count();
        System.out.printf("Unique symbols used: %d%n", countUnique);
        System.out.println(sb.toString());

    }

    private static void repeatStr(String text, int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            sb.append(text.toUpperCase());
        }
    }
}
