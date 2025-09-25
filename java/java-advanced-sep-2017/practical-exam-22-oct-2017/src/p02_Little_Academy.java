import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class p02_Little_Academy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] inputStones = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stones = new ArrayDeque<>();
        int gold = 0;

        Arrays.stream(inputStones).forEach(stones::push);

        String inputLine = reader.readLine();
        while (!"Revision".equals(inputLine)) {
            String[] tokens = inputLine.split("\\s+");
            String command = tokens[0] + " " + tokens[1];
            int n = Integer.parseInt(tokens[2]);

            if ("Apply acid".equals(command)) {
                for (int i = 1; i <= n; i++) {
                    if (stones.size() > 0) {
                        stones.push(stones.getLast() - 1);
                        if (stones.peek() == 0) {
                            stones.pop();
                            gold++;
                        }
                        stones.removeLast();
                    }
                }
            } else if ("Air leak".equals(command)) {
                if (gold > 0) {
                    stones.push(n);
                    gold--;
                }
            }

            inputLine = reader.readLine();
        }

        int[] stonesLeft = new int[stones.size()];
        for (int i = 0; i < stonesLeft.length; i++) {
            stonesLeft[i] = stones.getLast();
            stones.removeLast();
        }
        System.out.println(Arrays.stream(stonesLeft).mapToObj(i -> ((Integer) i).toString()).collect(Collectors.joining(" ")));
        System.out.println(gold);
    }
}
