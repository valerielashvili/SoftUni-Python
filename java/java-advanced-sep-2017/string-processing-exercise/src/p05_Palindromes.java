import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class p05_Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("[ .,?!]");
        TreeSet<String> palindromes = new TreeSet<>();

        for (String word : input) {
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();

            if (word.equals(sb.toString()) && !word.equals("")) {
                palindromes.add(word);
            }
        }

        System.out.println(palindromes);

    }
}
