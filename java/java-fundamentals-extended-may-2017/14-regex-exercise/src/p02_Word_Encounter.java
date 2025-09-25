import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_Word_Encounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        char character = inputLine.charAt(0);
        int n = Integer.parseInt(inputLine.substring(1, inputLine.length()));
        inputLine = scanner.nextLine();

        Pattern sentence = Pattern.compile("^[A-Z].+(?:[.?!])$");
        Pattern wordPattern = Pattern.compile("\\w+");
        String result = "";

        while (!"end".equals(inputLine)) {
            Matcher sentenceMatcher = sentence.matcher(inputLine);

            if (sentenceMatcher.find()){
                Matcher wordMatcher = wordPattern.matcher(inputLine);

                while (wordMatcher.find()) {
                    String word = wordMatcher.group();
                    int counter = 0;

                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) == character) {
                            counter++;
                        }
                    }
                    if (counter >= n) {
                        result += word + ", ";
                    }
                }
            }
            inputLine = scanner.nextLine();
        }
        result = result.substring(0, result.length() - 2);
        System.out.println(result);
    }
}
