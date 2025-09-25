import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04_Combinations_Count {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        long combinations = countCombinations(n , k);
        System.out.println(combinations);
    }

    private static long countCombinations(int n, int k) {
        long result = 1;
        for (int i = 1; i <= k; i++, n--)
            result = result * n / i;
        return result;
    }
}
