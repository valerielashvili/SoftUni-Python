import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p10_Semantic_HTML {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        String openTag = "(<(?<div>div\\s+)(.*?)" +
                "(?<idClass>(id|class)\\s*=\\s*\"(?<value>main|header|nav|article|section|aside|footer)\"\\s*)(.*)>)";
        Pattern pattern = Pattern.compile(openTag);

        String closeTag = "(?<=</)(?<closeTag>div>\\s*<!--\\s*" +
                "(?<closeValue>main|header|nav|article|section|aside|footer)\\s*--)(?=>)";
        Pattern closePattern = Pattern.compile(closeTag);

        StringBuilder text = new StringBuilder();
        while (!"END".equals(inputLine)) {
            Matcher matcher = pattern.matcher(inputLine);
            Matcher closeMatcher = closePattern.matcher(inputLine);

            if (matcher.find()) {
                inputLine = inputLine.replace(matcher.group("div"), matcher.group("value") + " ");
                inputLine = inputLine.replace(matcher.group("idClass"), "");
                inputLine = inputLine.replaceAll("\\s+", " ").replaceAll("\\s+>", ">");
            } else if (closeMatcher.find()) {
                inputLine = inputLine.replace(closeMatcher.group("closeTag"), closeMatcher.group("closeValue"));
            }
            text.append(inputLine).append("\n");
            inputLine = reader.readLine();
        }
        System.out.println(text);
    }
}
