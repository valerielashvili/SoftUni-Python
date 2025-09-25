import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class p09_Match_Full_Name {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        while (!"end".equals(inputLine)) {
            if (Pattern.matches("^[A-Z][a-z]+ [A-Z][a-z]+$", inputLine)) {
                System.out.println(inputLine);
            }
            inputLine = reader.readLine();
        }
    }
}
