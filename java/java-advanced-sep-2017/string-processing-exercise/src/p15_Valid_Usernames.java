import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p15_Valid_Usernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        Pattern pattern = Pattern.compile("(?<=^|[\\s/\\\\()])([a-zA-Z]\\w{2,24})(?=[\\s/\\\\()]|$)");
        Matcher matcher = pattern.matcher(inputLine);

        ArrayList<String> usernames = new ArrayList<>();

        while (matcher.find()) {
            usernames.add(matcher.group());
        }
        int maxLength = -1;
        int firstCoupPos = 0;
        for (int i = 0; i < usernames.size() - 1; i++) {
            int currentLength = usernames.get(i).length() + usernames.get(i + 1).length();
            if (maxLength < currentLength) {
                maxLength = currentLength;
                firstCoupPos = i;
            }
        }
        System.out.printf("%s\n%s", usernames.get(firstCoupPos), usernames.get(firstCoupPos + 1));
    }
}
