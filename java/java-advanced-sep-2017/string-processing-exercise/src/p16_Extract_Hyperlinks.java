import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p16_Extract_Hyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        StringBuilder text = new StringBuilder();
        while (!"END".equals(inputLine)) {
            text.append(inputLine).append("\n");
            inputLine = reader.readLine();
        }

        Pattern pattern = Pattern.compile("(?<=<a)\\s*[^>]*?href\\s*=\\s*(['\"]*)([^>]+?[a-z:/.]*)\\1\\s*[^>]*?\\s*(?=>)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(2));
        }
    }
}
