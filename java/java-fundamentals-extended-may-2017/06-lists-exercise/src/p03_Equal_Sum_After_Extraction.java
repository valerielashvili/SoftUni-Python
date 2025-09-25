import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p03_Equal_Sum_After_Extraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> firstList = IntStream.of(Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray())
                .boxed().collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Integer> secondList = IntStream.of(Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray())
                .boxed().collect(Collectors.toCollection(ArrayList::new));

        for (int i = 0; i < firstList.size(); i++) {
            for (int j = 0; j < secondList.size(); j++) {
                if (firstList.get(i).equals(secondList.get(j))) {
                    secondList.remove(j);
                    j--;
                }
            }
        }
        long sumList2 = secondList.stream().mapToInt(Integer::valueOf).sum();
        long sumList1 = firstList.stream().mapToInt(Integer::valueOf).sum();

        if (sumList1 == sumList2) {
            System.out.printf("Yes. Sum: %d", sumList2);
        } else {
            System.out.printf("No. Diff: %d", Math.abs(sumList1 - sumList2));
        }
    }
}
