import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p06_Insertion_Sort_Using_List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integersList = IntStream.of(Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Integer> resultList = insertionSort(integersList);

        StringBuilder sb = new StringBuilder();
        for (int num : resultList) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    private static ArrayList<Integer> insertionSort(ArrayList<Integer> intsList) {
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int firstIndex = 0; firstIndex < intsList.size(); firstIndex++) {

            int elementToInsert = intsList.get(firstIndex);
            boolean hasInserted = false;

            for (int secondIndex = 0; secondIndex < resultList.size(); secondIndex++) {
                int currentListElement = resultList.get(secondIndex);

                if (elementToInsert < currentListElement) {
                    resultList.add(secondIndex, elementToInsert);
                    hasInserted = true;
                    break;
                }
            }
            if (!hasInserted) {
                resultList.add(elementToInsert);
            }
        }
        return resultList;
    }
}
