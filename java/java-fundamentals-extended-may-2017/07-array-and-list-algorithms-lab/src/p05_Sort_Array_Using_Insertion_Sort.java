import java.util.Arrays;
import java.util.Scanner;

public class p05_Sort_Array_Using_Insertion_Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] integersArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Looping two loops, outer and inner (outer loop from position 0, inner loop from position "outer + 1")
        // and checking if current number is smaller than the previous one. The check should be repeated in the inner loop
        // until the smaller number is moved to the start of the array. - Implementation of Insertion Sort algorithm
        for (int firstUnsorted = 0; firstUnsorted < integersArray.length - 1; firstUnsorted++) {
            int i = firstUnsorted + 1;
            while (i > 0) {
                if (integersArray[i - 1] > integersArray[i]) {
                    swapIntegers(integersArray, i - 1, i);
                    i--;
                } else {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : integersArray) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    private static void swapIntegers(int[] intsArray, int previous, int current) {
        int currentNum = intsArray[current];
        intsArray[current] = intsArray[previous];
        intsArray[previous] = currentNum;
    }
}
