import java.util.Arrays;
import java.util.Scanner;

public class p02_String_Decryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mnElements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.stream(numbers).filter(n -> n >= 65 && n <= 90)
                .skip(mnElements[0])
                .limit(mnElements[1])
                .mapToObj(e -> (char)e)
                .forEach(c -> System.out.printf("%c", c));
    }
}
