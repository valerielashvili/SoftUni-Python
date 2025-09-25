import java.util.Arrays;
import java.util.Scanner;

public class p05_Decode_Radio_Frequencies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] frequencies = scanner.nextLine().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < frequencies.length; i++) {
            int[] tokens = Arrays.stream(frequencies[i].split("\\.")).mapToInt(Integer::parseInt).toArray();

            String firstChar = "" + (char) tokens[0];
            String secondChar = "" + (char) tokens[1];

            if (tokens[0] > 0) {
                sb.insert(i, firstChar);
            }
            if (tokens[1] > 0) {
                sb.insert(i + 1, secondChar);
            }
        }
        System.out.println(sb.toString());
    }
}
