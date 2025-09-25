import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class p06_Overlapping_Intervals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        TreeMap<Integer, Integer> intervals = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] nums = reader.readLine().split(",");
            intervals.put(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        }

        boolean isOverlapped = false;
        for (int i = 0; i < intervals.size() - 1; i++) {
            int currentStart = (int) intervals.keySet().toArray()[i];
            int currentEnd = intervals.get(currentStart);
            int nextStart = (int) intervals.keySet().toArray()[i + 1];

            if (currentStart <= nextStart && currentEnd >= nextStart) {
                isOverlapped = true;
                break;
            }
        }
        System.out.println(isOverlapped);
    }
}
