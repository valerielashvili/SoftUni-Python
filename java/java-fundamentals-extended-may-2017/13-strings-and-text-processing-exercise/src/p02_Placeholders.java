import java.util.Scanner;

public class p02_Placeholders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        while (!"end".equals(inputLine)) {
            String[] tokens = inputLine.split(" -> ");
            String resultStr = tokens[0];
            String wordsToSplit = tokens[1];
            String[] words = wordsToSplit.split(", ");

            for (int i = 0; i < words.length; i++) {
                String pattern = "{" + i + "}";
                resultStr = resultStr.replace(pattern, words[i]);
            }
            System.out.println(resultStr);

            inputLine = scanner.nextLine();
        }
    }
}
