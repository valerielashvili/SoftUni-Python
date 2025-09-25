import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_Booming_Cannon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] intArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String inputLine = scanner.nextLine();

        int distance = intArray[0];
        int countElements = intArray[1];

        Pattern pattern = Pattern.compile("\\\\<{3}.+?(?=\\\\<{3})|\\\\<{3}.+");
        Matcher matcher = pattern.matcher(inputLine);
        String result = "";

        while (matcher.find()) {
            String matchedStr = matcher.group();
            matchedStr = matchedStr.substring(4);

            if (matchedStr.length() > distance + countElements) {
                result += matchedStr.substring(distance, distance + countElements) + "/\\";
            } else if (matchedStr.length() < distance) {
                result += "";
            } else {
                result += matchedStr.substring(distance, matchedStr.length()) + "/\\";
            }
        }
        if (!result.isEmpty()) {
            result = result.substring(0, result.length() - 2);
        }
        System.out.println(result);
    }
}
