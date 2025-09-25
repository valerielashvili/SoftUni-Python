import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p01_Letter_Repetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String charsInput = scanner.nextLine();

        LinkedHashMap<Character, Integer> letterRepetition = new LinkedHashMap<>();

        for (int i = 0; i < charsInput.length(); i++) {
            char c = charsInput.charAt(i);
            
            if (!letterRepetition.containsKey(c)) {
                letterRepetition.put(c, 0);
            }
            letterRepetition.put(c, letterRepetition.get(c) + 1);
        }

        for (Map.Entry<Character, Integer> letterEntry : letterRepetition.entrySet()) {
            char c = letterEntry.getKey();
            int n = letterEntry.getValue();

            System.out.printf("%c -> %d\n", c, n);
        }
    }
}
