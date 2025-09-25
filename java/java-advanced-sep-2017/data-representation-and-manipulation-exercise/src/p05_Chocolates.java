import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p05_Chocolates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfPackets = Integer.parseInt(reader.readLine());
        int[] packets = Arrays.stream(reader.readLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int students = Integer.parseInt(reader.readLine());

        Arrays.sort(packets);
        int minDiff = calculateDifference(packets, numOfPackets, students);
        System.out.printf("Min Difference is %d.", minDiff);
    }

    private static int calculateDifference(int[] packets, int numOfPackets, int students) {
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < packets.length; i++) {

            if (i + students - 1 < numOfPackets) {
                int min = packets[i];
                int max = packets[i + students - 1];
                if (min > max) {
                    if (min - max < minDifference) {
                        minDifference = min - max;
                    }
                } else {
                    if (max - min < minDifference) {
                        minDifference = max - min;
                    }
                }
            }
        }
        return minDifference;
    }
}
