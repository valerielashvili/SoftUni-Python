import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p02_Integer_Insertion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> listOfIntegers = IntStream.of(Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toCollection(ArrayList::new));

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            int number = Integer.parseInt(input);
            int firstDigit = checkNumber(number);

            listOfIntegers.add(firstDigit, number);

            input = scanner.nextLine();
        }

        StringBuilder sb = new StringBuilder();
        for (int num : listOfIntegers) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static int checkNumber(int num) {
        while (num > 10) {
            num /= 10;
        }
        return num;
    }
}
