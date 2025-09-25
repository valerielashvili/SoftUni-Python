import java.util.Scanner;

public class p05_Char_Rotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strInput = scanner.nextLine();
        String[] intsInputArr = scanner.nextLine().split(" ");

        String charOutput = charRotation(strInput, intsInputArr);
        System.out.println(charOutput);

    }

    static String charRotation(String stringOfChars, String[] integersStrArr) {
        char[] charsArray = stringOfChars.toCharArray();
        int intCharValue = 0;
        char intToChar = '\0';
        String result = "";

        for (int i = 0; i < integersStrArr.length; i++) {
            int integer = Integer.parseInt(integersStrArr[i]);

            if (integer % 2 == 0) {
                intCharValue = charsArray[i];     // Getting numeric value of char
                intCharValue -= integer;          // From the char's value subtracting inputted integer
                intToChar = (char)intCharValue;   // Numeric value of the new character casting to char
                result += "" + intToChar;
            } else if (integer % 2 != 0) {
                intCharValue = charsArray[i];
                intCharValue += integer;
                intToChar = (char)intCharValue;
                result += "" + intToChar;
            }
        }
        return result;
    }
}
