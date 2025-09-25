import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p14_Sum_of_all_Values {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keysString = reader.readLine();
        String textString = reader.readLine();

        Pattern startKeyPattern = Pattern.compile("^[a-zA-Z_]+(?=[0-9])");
        Matcher startKeyMatcher = startKeyPattern.matcher(keysString);
        Pattern endKeyPattern = Pattern.compile("(?<=[0-9])[a-zA-Z_]+$");
        Matcher endKeyMatcher = endKeyPattern.matcher(keysString);
        String startKey = "";
        String endKey = "";

        if (startKeyMatcher.find() && endKeyMatcher.find()) {
            startKey = startKeyMatcher.group();
            endKey = endKeyMatcher.group();
            Pattern pattern = Pattern.compile("(?:" + startKey + ")([\\d.]+?)(?:" + endKey + ")");
            Matcher matcher = pattern.matcher(textString);
            double sum = 0.0;

            while (matcher.find()) {
                try {
                    sum += Double.parseDouble(matcher.group(1));
                } catch (NumberFormatException e) {
                }
            }
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println(sum > 0 ? "<p>The total value is: <em>" + df.format(sum) + "</em></p>"
                    : "<p>The total value is: <em>nothing</em></p>");
        } else {
            System.out.println("<p>A key is missing</p>");
        }
    }
}
