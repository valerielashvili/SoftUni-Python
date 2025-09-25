import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p07_Happiness_Index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        Pattern happyPattern = Pattern.compile("(?<happy>[:;][)D*\\]}]|[(\\[*c][:;])");
        Matcher happyMatcher = happyPattern.matcher(inputLine);

        Pattern sadPattern = Pattern.compile("(?<sad>[:;][(\\[{c]|[\\])D][:;])");
        Matcher sadMatcher = sadPattern.matcher(inputLine);

        if (happyMatcher.find() && sadMatcher.find()) {
            happyMatcher.reset();
            sadMatcher.reset();

            double happyEmoticonsCnt = 0;
            double sadEmoticonsCnt = 0;

            while (happyMatcher.find()) {
                happyEmoticonsCnt++;
            }
            while (sadMatcher.find()) {
                sadEmoticonsCnt++;
            }

            double happinessIndex = happyEmoticonsCnt / sadEmoticonsCnt;
            String emoticonScore = "";

            if (happinessIndex >= 2) {
                emoticonScore = ":D";
            } else if (happinessIndex > 1) {
                emoticonScore = ":)";
            } else if (happinessIndex == 1) {
                emoticonScore = ":|";
            } else {
                emoticonScore = ":(";
            }

            System.out.printf("Happiness index: %.2f %s%n", happinessIndex, emoticonScore);
            System.out.printf("[Happy count: %.0f, Sad count: %.0f]%n", happyEmoticonsCnt, sadEmoticonsCnt);
        }
    }
}
