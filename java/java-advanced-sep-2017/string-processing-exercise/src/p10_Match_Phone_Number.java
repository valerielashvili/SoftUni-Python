import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p10_Match_Phone_Number {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        while (!"end".equals(inputLine)) {
            Pattern pattern = Pattern.compile("^\\+359([ -])2\\1\\d{3}\\1\\d{4}$");
            Matcher matcher = pattern.matcher(inputLine);

            if (matcher.find()) {
                System.out.println(matcher.group());
            }

            inputLine = reader.readLine();
        }
    }
}
