import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p08_Melrah_Shake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder inputLine = new StringBuilder(reader.readLine());
        StringBuilder pattern = new StringBuilder(reader.readLine());

        while (pattern.length() > 0) {
            int firstMatch = inputLine.indexOf(pattern.toString());
            int lastMatch = inputLine.lastIndexOf(pattern.toString());

            if (firstMatch != -1 && lastMatch != -1) {
                inputLine.replace(firstMatch, firstMatch + pattern.length(), "");
                inputLine.replace(lastMatch - pattern.length(), lastMatch, "");

                pattern.deleteCharAt(pattern.length() / 2);
                System.out.println("Shaked it.");
            } else {
                break;
            }
        }
        System.out.println("No shake.");
        System.out.println(inputLine);
    }
}
