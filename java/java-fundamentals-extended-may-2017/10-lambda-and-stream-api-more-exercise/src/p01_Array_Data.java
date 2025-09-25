import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p01_Array_Data {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = IntStream.of(Arrays.stream(scanner.nextLine().split(" "))
        .mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toCollection(ArrayList::new));

        String command = scanner.nextLine();

        double average = numbers.stream().mapToInt(Integer::valueOf).average().getAsDouble();

        if ("Min".equals(command)) {
            System.out.println(numbers.stream().filter(n -> n >= average)
                    .mapToInt(Integer::valueOf)
                    .min().getAsInt());

        } else if ("Max".equals(command)) {
            System.out.println(numbers.stream().filter(n -> n >= average)
                    .mapToInt(Integer::valueOf)
                    .max().getAsInt());

        } else if ("All".equals(command)) {
            System.out.println(numbers.stream().filter(n -> n >= average)
                    .sorted((a, b) -> a.compareTo(b))
                    .map(Object::toString)
                    .collect(Collectors.joining(" ")));
        }
    }
}
