import java.util.Arrays;
import java.util.Scanner;

public class p01_Array_Contains_Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] integersArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int i = 0; i < integersArray.length; i++) {
            if (integersArray[i] == n) {
                isFound = true;
                break;
            }
        }

        if (isFound) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
