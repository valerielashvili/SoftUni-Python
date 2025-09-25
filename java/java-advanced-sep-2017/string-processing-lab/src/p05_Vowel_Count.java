import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p05_Vowel_Count {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        Pattern patter = Pattern.compile("[AEIOUYaeiouy]");
        Matcher matcher = patter.matcher(inputLine);

        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        System.out.println("Vowels: " + counter);
    }
}
