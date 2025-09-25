import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04_Recursive_Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int factorial = recursiveFactorial(n);
        System.out.println(factorial);
    }

    private static int recursiveFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * recursiveFactorial(n - 1);
    }
}
