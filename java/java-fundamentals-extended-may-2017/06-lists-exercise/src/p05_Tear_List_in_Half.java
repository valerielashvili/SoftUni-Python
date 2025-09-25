import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p05_Tear_List_in_Half {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> intList = IntStream.of(Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt).toArray())
                .boxed().collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Integer> secondSide = new ArrayList<>();

        int firstDigit = 0;
        int secondDigit = 0;

        secondSide.addAll(intList.subList(intList.size() / 2, intList.size()));
        intList = new ArrayList<>(intList.subList(0, intList.size() / 2));

        int counter = 0;
        for (int i = 0; i < intList.size(); i += 3) {
            firstDigit = secondSide.get(counter) / 10;
            secondDigit = secondSide.get(counter) % 10;

            intList.add(i, firstDigit);
            intList.add(i + 2, secondDigit);

            counter++;
        }

        System.out.println(intList.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
