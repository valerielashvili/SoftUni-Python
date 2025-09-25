import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class p02_Nested_Loops_To_Recursion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] array = new int[n];

        recursiveLoop(array, n, 0);
    }

    private static void recursiveLoop(int[] array, int n, int i) {
        if (i == n) {
            System.out.println(Arrays.stream(array)
                    .mapToObj(e -> ((Integer) e).toString())
                    .collect(Collectors.joining(" ")));
            return;
        }
        for (int j = 1; j <= n; j++) {
            array[i] = j;
            recursiveLoop(array, n, i + 1);
        }
    }
}
