import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p01_Average_Student_Grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<Double>> studentRecords = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int cnt = 0; cnt < n; cnt++) {
            String[] inputTokens = scanner.nextLine().split(" ");

            String name = inputTokens[0];
            double grade = Double.parseDouble(inputTokens[1]);

            if (!studentRecords.containsKey(name)) {
                studentRecords.put(name, new ArrayList<>());
            }
            studentRecords.get(name).add(grade);
        }
        for (Map.Entry<String, ArrayList<Double>> record : studentRecords.entrySet()) {
            String name = record.getKey();
            ArrayList<Double> grades = record.getValue();

            System.out.printf("%s -> ", name);

            int gradeCounter = 0;
            double average = 0.0;

            for (Double grade : grades) {
                gradeCounter++;
                average += grade;
                System.out.printf("%.2f ", grade);
            }
            average /= gradeCounter;
            System.out.printf("(avg: %.2f)\n", average);
        }
    }
}
