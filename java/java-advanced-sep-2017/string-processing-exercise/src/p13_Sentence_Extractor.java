import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p13_Sentence_Extractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keyWord = reader.readLine();
        String inputLine = reader.readLine();

        Pattern pattern = Pattern.compile("([A-Z][^.!?]+[a-z\\s]+\\b" + Pattern.quote(keyWord) + "\\b[^.?!]+[a-z\\s]+[.!?])");
        Matcher matcher = pattern.matcher(inputLine);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
