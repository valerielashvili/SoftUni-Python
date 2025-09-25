import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class p06_Academy_Graduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<String, double[]> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            double[] grades = Arrays.stream(reader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            students.putIfAbsent(name, grades);
        }

        students.entrySet()
                .forEach(s -> {
                    //DecimalFormat df = new DecimalFormat("#.###")
                    double average = Arrays.stream(s.getValue()).reduce(0.0, (a, b) -> a + b);
                    average /= s.getValue().length;
                    System.out.println(s.getKey() + " is graduated with " + average);
                });
    }
}
