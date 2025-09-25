import java.util.Scanner;

public class p08_String_Encryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String result = "";

        for (int i = 0; i < n; i++) {
            char inputLetters = scanner.nextLine().charAt(0);
            result = encryptStr(inputLetters);
            System.out.print(result);
        }
    }

    static String encryptStr(char letter) {
        int letterValue = letter;
        int firstDigit = 0;
        int lastDigit = 0;
        int firstLetterVal = 0;
        int lastLetterVal = 0;
        char firstChar;
        char lastChar;
        String result = "";

        // Encrypting letters based on their ASCII code
        if (letterValue < 100) {
            firstDigit = letterValue / 10;
        } else if (letterValue > 99) {
            firstDigit = letterValue / 100;
        }
        lastDigit = letterValue % 10;
        firstLetterVal = letterValue + lastDigit;
        lastLetterVal = letterValue - firstDigit;
        firstChar = (char)firstLetterVal;
        lastChar = (char)lastLetterVal;

        result = "" + firstChar + firstDigit + lastDigit + lastChar;
        return result;
    }
}
