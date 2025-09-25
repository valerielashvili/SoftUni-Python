import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_Distinct_List {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputElements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> distinctElements = new ArrayList<>();

        for (int i = 0; i < inputElements.length; i++) {

            if (!distinctElements.contains(inputElements[i])) { // If our list doesn't contain an element from
                distinctElements.add(inputElements[i]);         // inputElements[i], adding it to the new list
            }                                                   // to remove all repeating elements
        }
        StringBuilder sb = new StringBuilder();
        for (int number : distinctElements) {
            sb.append(number).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
