import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class p02_Hot_Potato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> queue = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));
        int n = Integer.parseInt(reader.readLine());

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            System.out.printf("Removed %s\n", queue.poll());
        }
        System.out.printf("Last is %s", queue.poll());
    }
}
