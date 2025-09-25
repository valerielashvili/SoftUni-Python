import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p03_Parse_Tags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        while (inputLine.contains("<upcase>")) {
            int upcaseStart = inputLine.indexOf("<upcase>");
            int upcaseEnd = inputLine.indexOf("</upcase>");
            String regionToChange = inputLine.substring(upcaseStart + 8, upcaseEnd);
            String changedText = regionToChange.toUpperCase();
            inputLine = inputLine.replace(regionToChange, changedText);
            inputLine = inputLine.replaceFirst("<upcase>", "");
            inputLine = inputLine.replaceFirst("</upcase>", "");
        }
        System.out.println(inputLine);
    }
}
