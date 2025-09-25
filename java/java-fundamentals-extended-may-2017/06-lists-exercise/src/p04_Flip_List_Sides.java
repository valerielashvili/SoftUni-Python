import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p04_Flip_List_Sides {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> intList = IntStream.of(Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray())
                .boxed().collect(Collectors.toCollection(ArrayList::new));

        //Take first and last number
        int firstNum = intList.get(0);
        int secondNum = intList.get(intList.size() - 1);

        //Remove first and last number
        intList.remove(0);
        intList.remove(intList.size() - 1);

        Collections.reverse(intList);

        //Return back first and last number
        intList.add(secondNum);
        intList.add(0, firstNum);

        StringBuilder sb = new StringBuilder();
        for (int number : intList) {
            sb.append(number).append(" ");
        }
        System.out.println(sb);
    }
}
