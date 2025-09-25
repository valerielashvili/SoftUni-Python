import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.IntStream;

public class p01_Basic_Stack_Operations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] elements = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int s = numbers[1];
        int x = numbers[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(elements).forEach(stack::push);
        IntStream.range(0, s).forEach(i -> stack.removeFirst());

        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            if (stack.size() == 0) {
                System.out.println(0);
            } else {
                int minValue = Integer.MAX_VALUE;
                for (int i = 0; i < stack.size(); i++) {
                    int currentNum = stack.pop();
                    if (currentNum < minValue) {
                        minValue = currentNum;
                    }
                }
                System.out.println(minValue);
            }
        }
    }
}
