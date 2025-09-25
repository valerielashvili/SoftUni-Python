import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02_Sum_Big_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstNum = reader.readLine();
        String secondNum = reader.readLine();

        int numMinLength = Math.min(firstNum.length(), secondNum.length());
        StringBuilder result = new StringBuilder();

        int remainder = 0;
        for (int i = 1; i <= numMinLength ; i++) {
            int firstDigit = Integer.parseInt(firstNum.substring(firstNum.length() - i, firstNum.length() - i + 1));
            int secondDigit = Integer.parseInt(secondNum.substring(secondNum.length() - i, secondNum.length() - i + 1));
            result.append((firstDigit + secondDigit + remainder) % 10);
            if (firstDigit + secondDigit + remainder >= 10) {
                remainder = 1;
            } else {
                remainder = 0;
            }
        }

        for (int i = firstNum.length() > secondNum.length() ?
                firstNum.length() - secondNum.length() - 1 :
                secondNum.length() - firstNum.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(firstNum.length() > secondNum.length() ?
                    firstNum.substring(i, i + 1) :
                    secondNum.substring(i, i + 1));
            result.append((digit + remainder) % 10);
            if (digit + remainder >= 10) {
                remainder = 1;
            } else {
                remainder = 0;
            }
        }

        if (remainder > 0) {
            result.append(remainder);
        }

        while(result.toString().endsWith("0")){
            result.delete(result.length() - 1, result.length());
        }

        System.out.println(result.reverse().toString());
    }
}
