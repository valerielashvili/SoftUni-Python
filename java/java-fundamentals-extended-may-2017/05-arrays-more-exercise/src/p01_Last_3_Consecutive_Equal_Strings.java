import java.util.Scanner;

public class p01_Last_3_Consecutive_Equal_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringInput = scanner.nextLine();

        String equalWords = findLastEqualWords(stringInput.split(" "));
        System.out.println(equalWords);
    }

    static String findLastEqualWords(String[] strInput) {
        String wordFirst = "";
        String wordSecond = "";
        String wordThird = "";
        String result = "";

        for (int i = strInput.length - 1; i >= 0; i--) {
            wordFirst = strInput[i];
            wordSecond = strInput[i - 1];
            wordThird = strInput[i - 2];

            if (wordFirst.equals(wordSecond) && wordSecond.equals(wordThird)) {
                result = wordFirst + " " + wordSecond + " " + wordThird;
                break;
            }
        }
        return result;
    }
}
