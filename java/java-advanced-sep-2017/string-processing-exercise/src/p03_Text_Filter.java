import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p03_Text_Filter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] banList = reader.readLine().split(", ");
        String inputText = reader.readLine();

        for (String word : banList) {
            String replacement = String.format("%" + word.length() + "d", 0).replace("0", "*")
                    .replace(" ", "*");
            inputText = inputText.replaceAll(word, replacement);
        }
        System.out.println(inputText);
    }
}
