import java.util.ArrayList;
import java.util.Scanner;

public class p01_Min_Max_Sum_Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(scanner.nextLine()));
        }
        // Calculating sum, min, max and average from inputted integers using Stream API
        int sum = numbers.stream().mapToInt(Integer::valueOf).sum();
        int min = numbers.stream().min(Integer::compareTo).get();
        int max = numbers.stream().max(Integer::compareTo).get();
        double average = numbers.stream().mapToDouble(Double::valueOf).average().getAsDouble();

        System.out.printf("Sum = %s\n", sum);
        System.out.printf("Min = %s\n", min);
        System.out.printf("Max = %s\n", max);
        System.out.printf("Average = %s\n",  average);
    }
}
