import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class p01_Odd_Occurrences {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> wordCount = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile(" ");
        String[] wordsInput = pattern.split(scanner.nextLine().toLowerCase());

        for (int i = 0; i < wordsInput.length; i++) {
            if (!wordCount.containsKey(wordsInput[i])) {
                wordCount.put(wordsInput[i], 0);
            }
            wordCount.put(wordsInput[i], wordCount.get(wordsInput[i]) + 1);
        }

        ArrayList<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> word : wordCount.entrySet()) {
            if (word.getValue() % 2 == 1) {
                result.add(word.getKey());
            }
        }
        System.out.println(result.toString().replace("[", "").replace("]", ""));
    }
}
