import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_Trainegram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        while (!"Traincode!".equals(inputLine)) {
            Pattern pattern = Pattern.compile("^(<\\[[^a-zA-Z\\d]*?]\\.)(\\.\\[[a-zA-Z\\d]*].)*$");
            Matcher matcher = pattern.matcher(inputLine);

            for (int i = 0; i < matcher.groupCount(); i++) {
                if (matcher.find()) {
                    String train = matcher.group();

                    System.out.println(train);
                }
            }
            inputLine = scanner.nextLine();
        }
    }
}
