import java.util.Arrays;
import java.util.Scanner;

public class p08_First_Odd_or_Even_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] intArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        String[] tokens = command.split(" ");

        int n = Integer.parseInt(tokens[1]);
        int counter = 0;

        if ("odd".equals(tokens[2])) {
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] % 2 != 0) {
                    System.out.printf("%d ", intArray[i]);
                    counter++;

                    if (counter == n) {
                        break;
                    }
                }
            }
        } else if ("even".equals(tokens[2])) {
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] % 2 == 0) {
                    System.out.printf("%d ", intArray[i]);
                    counter++;

                    if (counter == n) {
                        break;
                    }
                }
            }
        }
    }
}
