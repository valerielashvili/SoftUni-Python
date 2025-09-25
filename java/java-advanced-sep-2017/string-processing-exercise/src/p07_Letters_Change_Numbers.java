import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p07_Letters_Change_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        Double result = 0.0;

        for (int i = 0; i < input.length; i++) {
            int firstChar = input[i].charAt(0);
            int secondChar = input[i].charAt(input[i].length() - 1);
            double number = Double.parseDouble(input[i].substring(1, input[i].length() - 1));

            int letterPos;
            // The letter is Uppercase
            if (firstChar >= 65 && firstChar <= 90) {
                letterPos = firstChar - 64;
                number /= letterPos;
            } else if (firstChar >= 97 && firstChar <= 122) {
                letterPos = firstChar - 96;
                number *= letterPos;
            }

            if (secondChar >= 65 && secondChar <= 90) {
                letterPos = secondChar - 64;
                number -= letterPos;
            } else if (secondChar >= 97 && secondChar <= 122) {
                letterPos = secondChar - 96;
                number += letterPos;
            }
            result += number;
        }
        System.out.printf("%.2f", result);
    }
}
