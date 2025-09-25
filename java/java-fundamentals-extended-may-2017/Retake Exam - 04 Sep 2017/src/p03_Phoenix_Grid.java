import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class p03_Phoenix_Grid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        Pattern pattern = Pattern.compile("^(([^\\s_.]+?.{2})(\\.)*)*$");

        while (!"ReadMe".equals(inputLine)) {
            Matcher matcher = pattern.matcher(inputLine);
            if (matcher.find()) {
                String validMessage = matcher.group();
                StringBuilder sb = new StringBuilder(validMessage);
                String reversed = sb.reverse().toString();

                if (validMessage.equals(reversed)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }

            inputLine = scanner.nextLine();
        }
    }
}
