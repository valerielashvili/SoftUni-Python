import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p07_Find_the_Missing_Number {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(array);
        int missingNum = findMissingNum(array, n, 1);
        System.out.println(missingNum);
    }
    // Finding missing number recursively
    private static int findMissingNum(int[] array, int n, int i) {
        if (i < n) {
            if (i != array[i - 1]) {
                return i;
            }
            return findMissingNum(array, n, i + 1);
        }
        return i;
    }
}
