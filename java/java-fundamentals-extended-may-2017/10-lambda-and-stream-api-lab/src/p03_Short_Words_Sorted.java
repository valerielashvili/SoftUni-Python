import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_Short_Words_Sorted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String delimiter = "[.,:;()\\[\\]\"'\\\\/!? ]";

        String[] words = scanner.nextLine().toLowerCase().split(delimiter);

        System.out.println(Arrays.stream(words)
                .distinct()
                .filter(w -> w.length() < 5 && !w.isEmpty())
                .sorted().collect(Collectors.joining(", ")));
    }
}
