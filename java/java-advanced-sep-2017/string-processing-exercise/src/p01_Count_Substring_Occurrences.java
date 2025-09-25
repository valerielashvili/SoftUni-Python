import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p01_Count_Substring_Occurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        String searchStr = reader.readLine();

        int counter = 0;
        for (int i = 0; i < inputLine.length(); i++) {
            Pattern pattern = Pattern.compile("(?<=^.{" + i + "})(?i)" + searchStr);
            Matcher matcher = pattern.matcher(inputLine);

            while (matcher.find()) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
