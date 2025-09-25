import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p03_Recursive_Array_Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int sum = recursiveSum(array, 0);
        System.out.println(sum);
    }

    private static int recursiveSum(int[] array, int index) {
        if (index == array.length - 1) {
            // base case
            return array[index];
        }
        return array[index] + recursiveSum(array, index + 1);
    }
}
