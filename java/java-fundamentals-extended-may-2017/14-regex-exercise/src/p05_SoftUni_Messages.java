import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p05_SoftUni_Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        Pattern pattern = Pattern.compile("^(?<firstNum>\\d+)(?<message>[a-zA-Z]+)(?<secondNum>[^a-zA-Z\\s]*\\d+$)");

        while (!"Decrypt!".equals(inputLine)) {
            int m = Integer.parseInt(scanner.nextLine());
            Matcher matcher = pattern.matcher(inputLine);

            if (matcher.find()) {
                String message = matcher.group("message");
                String firstNum = matcher.group("firstNum");
                String secondNum = matcher.group("secondNum");

                if (m == message.length()) {
                    firstNum = unpolluteNumber(firstNum);
                    secondNum = unpolluteNumber(secondNum);
                    String numberAsStr = firstNum + secondNum;

                    int[] indicesArray = new int[numberAsStr.length()];
                    indicesArray = addIndices(indicesArray, numberAsStr);
                    String verificationCode = "";

                    for (int i = 0; i < indicesArray.length; i++) {
                        if (indicesArray[i] < message.length()) {
                            verificationCode += message.substring(indicesArray[i], indicesArray[i] + 1);
                        }
                    }
                        System.out.println(message + " = " + verificationCode);
                }
            }
            inputLine = scanner.nextLine();
        }
    }

    private static String unpolluteNumber(String pollutedNum) {
        String unpollutedNum = "";
        for (int i = 0; i < pollutedNum.length(); i++) {
            if (Character.isDigit(pollutedNum.charAt(i))) {
                unpollutedNum += pollutedNum.charAt(i);
            }
        }
        return unpollutedNum;
    }

    private static int[] addIndices(int[] digits, String numberAsStr) {
        char[] indices = numberAsStr.toCharArray();
        for (int i = 0; i < indices.length; i++) {
            digits[i] = indices[i] - '0';
        }
        return digits;
    }
}
