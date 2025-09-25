import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_Average_Character_Delimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringsArray = scanner.nextLine().split(" ");

        int lettersSum = 0;
        int letterCount = 0;

        for (int i = 0; i < stringsArray.length; i++) {
            for (int j = 0; j < stringsArray[i].length(); j++) {
                lettersSum += (int) stringsArray[i].charAt(j);
                letterCount++;
            }
        }
        double average = Math.floor(lettersSum / letterCount);
        char letterToChar = (char) average;
        String delimiterLetter = "" + Character.toUpperCase(letterToChar);

        System.out.println(Arrays.stream(stringsArray)
                .map(Object::toString)
                .collect(Collectors.joining(delimiterLetter)));
    }
}
