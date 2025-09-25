import java.text.Collator;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_Sort_Array_of_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringsArray = scanner.nextLine().split(" ");
        Collator collator = Collator.getInstance();

        // Sorting an array of strings using Collator so Java could sort the strings
        // placing lowercase letter words first, before uppercase words as it wishes from us
        // Open Judge System.
        for (int i = 0; i < stringsArray.length - 1; i++) {
            int j = i + 1;
            while (j > 0) {
                if (collator.compare(stringsArray[j], stringsArray[j - 1]) < 0) {
                    swapElements(stringsArray, j - 1, j);
                    j--;
                } else {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String word : stringsArray) {
            sb.append(word).append(" ");
        }
        System.out.println(sb.toString().trim());

        //System.out.println(Arrays.stream(stringsArray).collect(Collectors.joining(" ")));
    }

    private static void swapElements(String[] array, int previous, int current) {
        String currentStr = array[current];
        array[current] = array[previous];
        array[previous] = currentStr;
    }
}
