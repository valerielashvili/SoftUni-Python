import java.util.Arrays;
import java.util.Scanner;

public class p05_Odd_and_Even_Pairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] intArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (intArray.length % 2 == 0) {
            for (int i = 0; i < intArray.length - 1; i += 2) {
                if (intArray[i] % 2 == 0 && intArray[i + 1] % 2 == 0) {
                    System.out.printf("%d, %d -> both are even\n", intArray[i], intArray[i + 1]);
                } else if (intArray[i] % 2 != 0 && intArray[i + 1] % 2 != 0) {
                    System.out.printf("%d, %d -> both are odd\n", intArray[i], intArray[i + 1]);
                } else {
                    System.out.printf("%d, %d -> different\n", intArray[i], intArray[i + 1]);
                }
            }
        } else {
            System.out.println("invalid length");
        }
    }
}
