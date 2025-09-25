import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class p03_Math_Potato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> queue = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));
        int n = Integer.parseInt(reader.readLine());

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle)) {
                System.out.printf("Prime %s\n", queue.peek());
            } else {
                System.out.printf("Removed %s\n", queue.poll());
            }
            cycle++;
        }
        System.out.printf("Last is %s", queue.poll());
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int divisor = 2; divisor <= Math.sqrt(n); divisor++) {
            if (n % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
