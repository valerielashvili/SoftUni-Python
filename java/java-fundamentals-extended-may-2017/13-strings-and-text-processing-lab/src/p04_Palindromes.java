import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p04_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputText = scanner.nextLine().split(", |\\. |\\? |! |[,.?! ]");

        String[] palindromes = Arrays.stream(inputText)
                .filter(w -> w.equals(new StringBuilder(w).reverse().toString()) && !w.isEmpty())
                .sorted((a, b) -> a.toLowerCase().compareTo(b.toLowerCase()))
                .distinct()
                .toArray(String[]::new);

        System.out.println(Arrays.stream(palindromes)
        .collect(Collectors.joining(", ")));
    }
}
