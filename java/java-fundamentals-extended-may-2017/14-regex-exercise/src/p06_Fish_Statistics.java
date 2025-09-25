import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p06_Fish_Statistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        Pattern pattern = Pattern.compile("(?<tail>>*)<(?<body>\\(+)(?<eye>['\\-x])>");
        Matcher matcher = pattern.matcher(inputLine);

        if (!matcher.find()) {
            System.out.printf("No fish found.");
        }
        matcher.reset();

        int counter = 1;
        while (matcher.find()) {
            String tail = matcher.group("tail");
            String body = matcher.group("body");
            String eye = matcher.group("eye");

            String tailType = "";
            String bodyType = "";
            String fishStatus = "";

            System.out.printf("Fish %d: %s\n", counter, matcher.group());

            if (tail.length() > 5) {
                tailType = "Long";
            } else if (tail.length() > 1) {
                tailType = "Medium";
            } else if (tail.length() == 1) {
                tailType = "Short";
            } else {
                tailType = "None";
            }

            if (body.length() > 10) {
                bodyType = "Long";
            } else if (body.length() > 5) {
                bodyType = "Medium";
            } else {
                bodyType = "Short";
            }

            if ("'".equals(eye)) {
                fishStatus = "Awake";
            } else if ("-".equals(eye)) {
                fishStatus = "Asleep";
            } else if ("x".equals(eye)){
                fishStatus = "Dead";
            }

            if (tailType.equals("None")) {
                System.out.printf("  Tail type: %s\n", tailType);
            } else {
                System.out.printf("  Tail type: %s (%d cm)\n", tailType, tail.length() * 2);
            }
            System.out.printf("  Body type: %s (%d cm)\n", bodyType, body.length() * 2);
            System.out.printf("  Status: %s\n", fishStatus);

            counter++;
        }
    }
}
