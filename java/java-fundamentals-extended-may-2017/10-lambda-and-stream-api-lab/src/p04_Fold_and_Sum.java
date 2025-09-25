import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p04_Fold_and_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        int k = numbers.size() / 4;

        ArrayList<Integer> leftPart = numbers.stream().limit(k).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(leftPart);

        ArrayList<Integer> rightPart = numbers.stream()
                .skip(3 * k)
                .limit(k)
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(rightPart);

        ArrayList<Integer> downPart = numbers.stream()
                .skip(k)
                .limit(2 * k)
                .collect(Collectors.toCollection(ArrayList::new));

        leftPart.addAll(rightPart);

        for (int i = 0; i < downPart.size(); i++) {
            downPart.set(i, downPart.get(i) + leftPart.get(i));
        }

        System.out.println(downPart.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
