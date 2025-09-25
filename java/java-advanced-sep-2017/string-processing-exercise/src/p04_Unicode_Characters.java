import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04_Unicode_Characters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputLine.length(); i++) {
            result.append("\\u").append(Integer.toHexString(inputLine.charAt(i) | 0x10000).substring(1));
        }
        System.out.printf(result.toString());
    }
}
