import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p06_Magic_Exchangeable_Words {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s");

        String firstWord = "";
        String secondWord = "";
        for (int i = 0; i < input[0].length(); i++) {
            if (!firstWord.contains(String.valueOf(input[0].charAt(i)))) {
                firstWord += input[0].charAt(i);
            }
        }
        for (int i = 0; i < input[1].length(); i++) {
            if (!secondWord.contains(String.valueOf(input[1].charAt(i)))) {
                secondWord += input[1].charAt(i);
            }
        }
        System.out.println(firstWord.length() == secondWord.length() ? "true" : "false");
    }
}
