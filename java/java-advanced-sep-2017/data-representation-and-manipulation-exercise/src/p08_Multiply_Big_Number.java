import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p08_Multiply_Big_Number {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstNum = reader.readLine();
        int secondNum = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();

        int remainder = 0;
        for (int i = 1; i <= firstNum.length() ; i++) {
            int firstDigit = Integer.parseInt(firstNum.substring(firstNum.length() - i, firstNum.length() - i + 1));
            result.append((firstDigit * secondNum + remainder) % 10);
            if (firstDigit * secondNum + remainder >= 10) {
                remainder = (firstDigit * secondNum + remainder) / 10;
            } else {
                remainder = 0;
            }
        }

        if (remainder > 0) {
            result.append(remainder);
        }

        while(result.toString().endsWith("0")) {
            result.delete(result.length() - 1, result.length());
        }
        if (result.length() == 0) {
            result.append(0);
        }
        System.out.println(result.reverse().toString());
    }
}
