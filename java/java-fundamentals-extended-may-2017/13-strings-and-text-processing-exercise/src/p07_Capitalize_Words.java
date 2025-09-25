import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p07_Capitalize_Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        while (!"end".equals(inputLine)) {
            String[] tokens = inputLine.split("[ ,.!?@#$%^&*()\\-+;:]");
            tokens = Arrays.stream(tokens).filter(e -> e.length() > 0).toArray(String[]::new);

            for (int i = 0; i < tokens.length; i++) {
                char letter = tokens[i].charAt(0);
                letter = Character.toUpperCase(letter);
                tokens[i] = tokens[i].toLowerCase();
                tokens[i] = letter + tokens[i].substring(1);
            }

            System.out.println(Arrays.stream(tokens).collect(Collectors.joining(", ")));

            inputLine = scanner.nextLine();
        }
    }
}
