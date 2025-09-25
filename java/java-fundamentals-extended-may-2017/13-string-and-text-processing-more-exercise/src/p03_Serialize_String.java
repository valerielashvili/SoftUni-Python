import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_Serialize_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        LinkedHashMap<Character, ArrayList<String>> charIndexes = new LinkedHashMap<>();

        for (int i = 0; i < inputLine.length(); i++) {
            char character = inputLine.charAt(i);
            String indexToChar = Integer.toString(i);

            charIndexes.putIfAbsent(character, new ArrayList<>());
            charIndexes.get(character).add(indexToChar);
        }

        charIndexes.entrySet().forEach(c -> {
            System.out.printf("%s:%s\n", c.getKey(), c.getValue()
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("/")));
        });
    }
}
