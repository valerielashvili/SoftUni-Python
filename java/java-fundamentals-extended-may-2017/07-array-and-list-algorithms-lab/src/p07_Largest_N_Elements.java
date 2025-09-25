import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p07_Largest_N_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> listOfIntegers = IntStream.of(Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toCollection(ArrayList::new));

        int n = Integer.parseInt(scanner.nextLine());

        boolean hasInserted;

        do {
            hasInserted = false;
            for (int i = 0; i < listOfIntegers.size() - 1; i++) {
                int nextElement = listOfIntegers.get(i + 1);

                if (listOfIntegers.get(i) < listOfIntegers.get(i + 1)) {
                    int temp = listOfIntegers.get(i);
                    listOfIntegers.set(i, nextElement);
                    listOfIntegers.set(i + 1, temp);
                    hasInserted = true;
                }
            }
        } while (hasInserted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
                sb.append(listOfIntegers.get(i)).append(" ");
            }
            System.out.println(sb);
        }
    }
