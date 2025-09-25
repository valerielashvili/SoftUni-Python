import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p01_Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] intArray = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        // There is some problem in Judge with Bubble sort when using method to swap elements
        // Selection sort (do - while variant of the Selection sort works with negative numbers)
        boolean swapped;
        do {
            swapped = false;
            int min = 0;
            int current = 0;
            for (int i = 0; i < intArray.length - 1; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    current = i;
                    min = i + 1;
                    swapped = true;
                }
            }
            swap(intArray, min, current);
        } while (swapped);

        // Selection sort (doesn't work with negative numbers)
        /*for (int i = 0; i < intArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] > intArray[j]) {
                    min = j;
                }
            }
            swap(intArray, min, i);
        }*/
        // Bubble sort
        /*boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < intArray.length - 1; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i + 1, i);
                    swapped = true;
                }
            }
        } while (swapped);*/

        for (int i = 0; i < intArray.length; i++) {
            System.out.printf("%d ", intArray[i]);
        }
    }

    private static void swap(int[] array, int min, int i) {
        int temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }
}
