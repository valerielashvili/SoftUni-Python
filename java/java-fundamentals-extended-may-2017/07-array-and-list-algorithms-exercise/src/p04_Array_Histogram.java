import java.util.ArrayList;
import java.util.Scanner;

public class p04_Array_Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringsArray = scanner.nextLine().split(" ");

        ArrayList<Integer> occurrences = new ArrayList<>();
        ArrayList<String> uniqueWords = new ArrayList<>();

        // Finding occurrences
        for (int i = 0; i < stringsArray.length; i++) {
            int counter = 0;
            if (uniqueWords.contains(stringsArray[i])) {
                continue;
            }
            for (int j = i; j < stringsArray.length; j++) {

                if (stringsArray[i].equals(stringsArray[j])) {
                    counter++;
                    if (!uniqueWords.contains(stringsArray[i])) {
                        occurrences.add(1);
                        uniqueWords.add(stringsArray[i]);
                    }
                    occurrences.set(occurrences.size() - 1, counter);
                }
            }
        }

        // Sorting occurrences and respectively uniqueWords lists
        for (int i = 0; i < occurrences.size() - 1; i++) {
            int j = i + 1;
            while (j > 0) {
                if (occurrences.get(j) > occurrences.get(j - 1)) {
                    swapElements(occurrences, uniqueWords, j - 1, j);
                    j--;
                } else {
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < occurrences.size(); i++) {
            sum += occurrences.get(i);
        }

        // Printing the data
        for (int i = 0; i < occurrences.size(); i++) {
            System.out.printf("%s -> %d times ", uniqueWords.get(i), occurrences.get(i));
            double percentage = (double) occurrences.get(i) / sum * 100;
            System.out.printf("(%.2f%%)\n", percentage);
        }
    }

    private static void swapElements(ArrayList<Integer> intArray, ArrayList<String> words, int previous, int current) {
        // Sorting occurrences and uniqueWords lists at the same time
        int currentInt = intArray.get(current);
        intArray.set(current, intArray.get(previous));
        intArray.set(previous, currentInt);

        String currentWord = words.get(current);
        words.set(current, words.get(previous));
        words.set(previous, currentWord);

    }
}
