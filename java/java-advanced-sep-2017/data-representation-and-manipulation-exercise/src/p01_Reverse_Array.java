import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class p01_Reverse_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        reverseArray(array, array.length - 1);

        System.out.println(Arrays.stream(array)
                .mapToObj(i -> ((Integer) i).toString())
                .collect(Collectors.joining(" ")));
    }

    private static void reverseArray(int[] array, int i) {
        if (i < (array.length + 1) / 2) {
            return;
        }
        int current = array.length - 1 - i;
        int temp = array[i];
        array[i] = array[current];
        array[current] = temp;
        reverseArray(array, i - 1);
    }
}
