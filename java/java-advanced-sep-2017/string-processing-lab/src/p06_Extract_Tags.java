import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p06_Extract_Tags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        while (!"END".equals(inputLine)) {
            Pattern pattern = Pattern.compile("<.+?>");
            Matcher matcher = pattern.matcher(inputLine);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
            inputLine = reader.readLine();
        }
    }
}
