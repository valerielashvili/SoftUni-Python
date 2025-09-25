import java.util.Arrays;
import java.util.Scanner;

public class p02_Smallest_Element_in_Array {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] integersArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int smallestInt = Integer.MAX_VALUE;

        for (int i = 0; i < integersArray.length; i++) {
            if (integersArray[i] < smallestInt) {
                smallestInt = integersArray[i];
            }
        }
        System.out.println(smallestInt);
    }
}
