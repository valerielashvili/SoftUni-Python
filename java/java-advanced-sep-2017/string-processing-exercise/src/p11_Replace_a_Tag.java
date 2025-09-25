import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p11_Replace_a_Tag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        StringBuilder result = new StringBuilder();
        while (!"END".equals(inputLine)) {
            result.append(inputLine).append("\n");
            inputLine = reader.readLine();
        }

        Pattern pattern = Pattern.compile("<a(.+?)>(.*?)</a>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(result);

        while (matcher.find(0)) {
            int startIndex = matcher.start();
            int endIndex = matcher.end();

            String replacement = "[URL" + matcher.group(1) + "]" + matcher.group(2) + "[/URL]";
            result.replace(startIndex, endIndex, replacement);
        }
        System.out.println(result);
    }
}
