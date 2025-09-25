import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p06_Stuck_Zipper {
    static ArrayList<Integer> firstList;
    static ArrayList<Integer> secondList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        firstList = IntStream.of(Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray())
                .boxed().collect(Collectors.toCollection(ArrayList::new));

        secondList = IntStream.of(Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray())
                .boxed().collect(Collectors.toCollection(ArrayList::new));

        int minimumDigits = 0;
        boolean minDigitsFound = false;

        // Finding smallest amount of digits in both of the lists
        while (!minDigitsFound) {
            int minFirst = findMinFirst();
            int minSecond = findMinSecond();

            if (minFirst < minSecond) {
                minimumDigits = minFirst;
                minDigitsFound = true;
            } else {
                minimumDigits = minSecond;
                minDigitsFound = true;
            }
        }
        removeElements(minimumDigits);

        // Zipping both lists
        int position = 0;
        if (firstList.size() > 0 || secondList.size() > 0) {

            for (int i = 0; i < firstList.size(); i++) {
                secondList.add(position + 1, firstList.get(i));
                position += 2;
                if (position >= secondList.size()) {
                    position--;
                }
            }
        }

        System.out.println(secondList.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }

    private static int findMinFirst() {
        int minDigits = Integer.MAX_VALUE;

        for (int i = 0; i < firstList.size(); i++) {
            int currentNum = Math.abs(firstList.get(i));
            String numToStr = "" + currentNum;

            if (numToStr.length() < minDigits) {
                minDigits = numToStr.length();
            }
        }
        return minDigits;
    }

    private static int findMinSecond() {
        int minDigits = Integer.MAX_VALUE;

        for (int i = 0; i < secondList.size(); i++) {
            int currentNum = Math.abs(secondList.get(i));
            String numToStr = "" + currentNum;

            if (numToStr.length() < minDigits) {
                minDigits = numToStr.length();
            }
        }
        return minDigits;
    }

    private static void removeElements(int minDigits) {
        int currentNum = 0;
        String numToStr = "";

        for (int i = 0; i < firstList.size(); i++) {
            currentNum = Math.abs(firstList.get(i));
            numToStr = "" + currentNum;
            if (minDigits < numToStr.length()) {
                firstList.remove(i);
                i--;
            }
        }
        currentNum = 0;
        numToStr = "";

        for (int i = 0; i < secondList.size(); i++) {
            currentNum = Math.abs(secondList.get(i));
            numToStr = "" + currentNum;
            if (minDigits < numToStr.length()) {
                secondList.remove(i);
                i--;
            }
        }
    }
}
