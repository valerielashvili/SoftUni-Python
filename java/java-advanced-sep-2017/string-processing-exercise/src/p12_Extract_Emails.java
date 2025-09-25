import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p12_Extract_Emails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        Pattern pattern = Pattern.compile("(?<=^|\\s)([a-z0-9]+[-._]?[a-z]+)@([a-z]+-?)+(\\.[a-z]+)+\\b");
        Matcher matcher = pattern.matcher(inputLine);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
