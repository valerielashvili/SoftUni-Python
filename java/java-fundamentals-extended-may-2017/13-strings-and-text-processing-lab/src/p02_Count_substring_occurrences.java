import java.util.Scanner;

public class p02_Count_substring_occurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        String searchString = scanner.nextLine().toLowerCase();

        int counter = 0;
        int foundIndex = input.indexOf(searchString);

        while (foundIndex != -1) {
            counter++;
            foundIndex = input.indexOf(searchString, foundIndex + 1);
        }
        System.out.println(counter);
    }
}
