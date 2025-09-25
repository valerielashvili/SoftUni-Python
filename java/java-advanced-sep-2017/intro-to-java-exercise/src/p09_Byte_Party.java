import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p09_Byte_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] intArray = new int[n];

        for (int i = 0; i < n; i++) {
            intArray[i] = Integer.parseInt(scanner.nextLine());
        }

        String[] inputLine = scanner.nextLine().split("\\s+");

        while (!"over".equals(inputLine[1])) {
            int action = Integer.parseInt(inputLine[0]);
            int p = Integer.parseInt(inputLine[1]);
            int mask = 0;

            for (int i = 0; i < intArray.length; i++) {
                if (action == -1) {
                    intArray[i] = intArray[i] ^ (1 << p);
                } else if (action == 0) {
                    mask = ~(1 << p);
                    intArray[i] = intArray[i] & mask;
                } else if (action == 1) {
                    mask = 1 << p;
                    intArray[i] = intArray[i] | mask;
                }
            }
            inputLine = scanner.nextLine().split("\\s+");
        }
        System.out.println(Arrays.stream(intArray)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining("\n")));
    }
}
