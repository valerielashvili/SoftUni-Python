import java.util.Arrays;
import java.util.Scanner;

public class p04_Sort_Array_Using_Bubble_Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] integers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < integers.length - 1; i++) {
                if (integers[i] > integers[i + 1]) {
                    swapIntegers(integers, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);

        StringBuilder sb = new StringBuilder();
        for (int num : integers) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    private static void swapIntegers(int[] intsArray, int i, int iterNext) {
        int swap = intsArray[i];
        intsArray[i] = intsArray[iterNext];
        intsArray[iterNext] = swap;
    }
}
