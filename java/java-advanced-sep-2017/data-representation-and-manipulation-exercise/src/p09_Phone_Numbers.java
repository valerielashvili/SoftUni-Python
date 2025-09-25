import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p09_Phone_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        StringBuilder text = new StringBuilder();
        StringBuilder contacts = new StringBuilder("<ol>");

        while (!"END".equals(inputLine)) {
            text.append(inputLine);
            inputLine = reader.readLine();
        }

        Pattern pattern = Pattern.compile("([A-Z][a-zA-Z]*)([^a-zA-Z+\\d]*)(\\+?\\d[()\\\\/.\\-\\s\\d]*\\d)");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            matcher.reset();
            while (matcher.find()) {
                String name = matcher.group(1);
                String phoneNumber = matcher.group(3);
                phoneNumber = phoneNumber.replaceAll("[^+0-9]", "");

                contacts.append("<li><b>").append(name).append(":</b> ").append(phoneNumber).append("</li>");
            }
            contacts.append("</ol>");
            System.out.println(contacts);
        } else {
            System.out.println("<p>No matches!</p>");
        }
    }
}
