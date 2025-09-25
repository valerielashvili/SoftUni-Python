import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class p04_Deserialize_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        LinkedHashMap<Character, ArrayList<String>> charIndexes = new LinkedHashMap<>();

        while (!"end".equals(inputLine)) {
            char character = inputLine.charAt(0);
            String strToSplit = inputLine.substring(2);
            String[] indexes = strToSplit.split("/");

            charIndexes.putIfAbsent(character, new ArrayList<>());

            for (int i = 0; i < indexes.length; i++) {
                charIndexes.get(character).add(indexes[i]);
            }

            inputLine = scanner.nextLine();
        }

        int indexesSum = charIndexes.values()
                .stream()
                .flatMapToInt(e -> e.stream().mapToInt(Integer::valueOf)).sum();

        char[] charArr = new char[indexesSum];
        charIndexes.entrySet().forEach(c -> c.getValue().forEach(v -> charArr[Integer.valueOf(v)] = c.getKey()));

        String outputString = new String(charArr);
        System.out.println(outputString);
    }
}
