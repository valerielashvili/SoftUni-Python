import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p07_Valid_Usernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");
        StringBuilder result = new StringBuilder();

        int counter = 0;
        while (!"END".equals(inputLine)) {
            Matcher matcher = pattern.matcher(inputLine);

            if (matcher.find()) {
                counter++;
                result.append("valid");
                result.append("\n");
            } else {
                result.append("invalid");
                result.append("\n");
            }
            inputLine = reader.readLine();
        }
        if (counter > 0) {
            System.out.println(result.toString());
        }
    }
}
