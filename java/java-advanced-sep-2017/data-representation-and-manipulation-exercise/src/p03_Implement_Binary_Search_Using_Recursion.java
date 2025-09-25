import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p03_Implement_Binary_Search_Using_Recursion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(reader.readLine());

        int index = recursiveBinarySearch(array, x, 0, array.length - 1);
        System.out.println(index);
    }

    private static int recursiveBinarySearch(int[] array, int x, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (x < array[mid]) {
                return recursiveBinarySearch(array, x, start, mid - 1);
            } else if (x > array[mid]) {
                return recursiveBinarySearch(array, x, mid + 1, end);
            } else {
                return mid;
            }
        }
        return -1;
    }
}
